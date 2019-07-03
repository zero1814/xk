package org.product.query.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.product.entity.PcBrand;
import org.product.entity.category.PcCategory;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductStatus;
import org.product.entity.store.PcStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zero.spring.jpa.QueryType;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.DateUtil;

@Component
@Slf4j
public class PcProductQuery {
	@Autowired
	private EntityManager em;

	public PcProduct getEntityByCode(String code) {
		PcProduct product = null;
		Query query = em.createQuery("from PcProduct where code=:code", PcProduct.class);
		query.setParameter("code", code);
		if (query.getSingleResult() != null) {
			product = (PcProduct) query.getSingleResult();
		}
		return product;
	}

	public PcProduct productQuery(String code) {
		String sql = "select code,name,en_name,main_pic,album,brand,category,status,store from pc_product where code='"
				+ code + "'";
		Query query = em.createNativeQuery(sql.toString());
		Object result = query.getSingleResult();
		Object[] list = (Object[]) result;
		PcProduct product = new PcProduct();
		product.setCode(list[0].toString());
		product.setName(list[1].toString());
		product.setMainPic(list[3].toString());
		// 品牌
		PcBrand brand = new PcBrand();
		brand.setCode(list[5].toString());
		product.setBrand(brand);
		// 分类
		PcCategory category = new PcCategory();
		category.setCode(list[6].toString());
		product.setCategory(category);
		// 状态
		PcProductStatus status = new PcProductStatus();
		status.setCode(list[7].toString());
		product.setStatus(status);
		// 状态
		PcStore store = new PcStore();
		store.setCode(list[8].toString());
		product.setStore(store);
		return product;
	}

	/**
	 * 
	 * 方法: pageListQuery <br>
	 * 描述: 获取分页列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月17日 上午11:10:14
	 * 
	 * @param entity
	 * @param type
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PcProduct> pageListQuery(PcProduct entity) {
		try {
			String sql = pageQuerySql(entity, QueryType.PAGE_LIST);
			Query query = em.createNativeQuery(sql.toString());
			// 分页
			int start = (entity.getPage() - 1) * entity.getSize();
			int size = entity.getSize();
			query.setFirstResult(start);
			query.setMaxResults(size);
			query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			List<Object> list = query.getResultList();
			if (list.isEmpty()) {
				return null;
			}
			// 根据sql查询获取集合
			List<PcProduct> productData = new ArrayList<PcProduct>();
			for (Object obj : list) {
				Map map = (Map) obj;
				PcProduct product = new PcProduct();
				// 编码
				product.setCode(map.get("code") != null ? map.get("code").toString() : "");
				// 名称
				product.setName(map.get("name") != null ? map.get("name").toString() : "");
				// 主图
				product.setMainPic(map.get("main_pic") != null ? map.get("main_pic").toString() : "");
				// 品牌
				PcBrand brand = new PcBrand();
				brand.setName(map.get("brand") != null ? map.get("brand").toString() : "");
				product.setBrand(brand);
				// 店铺
				PcStore store = new PcStore();
				store.setName(map.get("store") != null ? map.get("store").toString() : "");
				product.setStore(store);
				// 商品分类
				PcCategory category = new PcCategory();
				category.setName(map.get("category") != null ? map.get("category").toString() : "");
				product.setCategory(category);
				// 销售价格
				BigDecimal minSellPrice = BigDecimal.valueOf(
						map.get("min_sell_price") != null ? Double.valueOf(map.get("min_sell_price").toString())
								: 0.00);
				product.setMinSellPrice(minSellPrice);
				BigDecimal maxSellPrice = BigDecimal.valueOf(
						map.get("max_sell_price") != null ? Double.valueOf(map.get("max_sell_price").toString())
								: 0.00);
				product.setMaxSellPrice(maxSellPrice);
				// 状态
				PcProductStatus status = new PcProductStatus();
				status.setName(map.get("status") != null ? map.get("status").toString() : "");
				product.setStatus(status);
				// 创建时间
				product.setCreateTime(DateUtil.stringToDate(map.get("create_time").toString()));
				// 修改时间
				product.setUpdateTime(DateUtil.stringToDate(map.get("update_time").toString()));
				productData.add(product);
			}
			return productData;
		} catch (Exception e) {
			log.error("商品查询分页失败");
			return null;
		}
	}

	/**
	 * 
	 * 方法: pageTotalQuery <br>
	 * 描述: 获取集合总数 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月17日 上午11:10:00
	 * 
	 * @param entity
	 * @return
	 */
	public Long pageTotalQuery(PcProduct entity) {
		try {
			String sql = pageQuerySql(entity, QueryType.PAGE_TOTAL);
			Object totalObject = em.createNativeQuery(sql).getSingleResult();
			Long total = Long.valueOf(totalObject.toString());
			return total;
		} catch (Exception e) {
			log.error("商品查询分页失败");
			return null;
		}
	}

	private static String pageQuerySql(PcProduct entity, QueryType type) {
		StringBuffer sql = new StringBuffer();
		if (type == QueryType.PAGE_LIST) {
			sql.append(
					"SELECT p.code,p.name,p.main_pic,p.min_sell_price,p.max_sell_price,store.name as store,b.name AS brand,c.name AS category,s.name AS status,p.create_time,p.update_time");
		} else {
			sql.append("SELECT count(1) ");
		}
		sql.append(" FROM pc_product AS p LEFT JOIN pc_product_status AS s ON p.status = s.code");
		sql.append(" LEFT JOIN pc_brand AS b ON p.brand = b.code");
		sql.append(" LEFT JOIN pc_category AS c ON p.category = c.code");
		sql.append(" LEFT JOIN pc_store as store ON p.store = store.code");
		sql.append(" where 1=1 ");
		if (StringUtils.isNotBlank(entity.getName())) {
			sql.append(" and p.name like CONCAT('%','" + entity.getName() + "','%') ");
		} else if (entity.getStatus() != null && StringUtils.isNotBlank(entity.getStatus().getCode())) {
			sql.append(" and s.code = '" + entity.getStatus().getCode() + "'");
		} else if (entity.getBrand() != null && StringUtils.isNotBlank(entity.getBrand().getCode())) {
			sql.append(" and b.code = '" + entity.getBrand().getCode() + "' ");
		} else if (entity.getCategory() != null && StringUtils.isNotBlank(entity.getCategory().getCode())) {
			sql.append(" and c.code = '" + entity.getCategory().getCode() + "'");
		} else if (entity.getStore() != null && StringUtils.isNotBlank(entity.getStore().getCode())) {
			sql.append(" and store.code = '" + entity.getStore().getCode() + "'");
		}
		log.info("执行分页查询数据sql:\n" + sql);
		return sql.toString();
	}
}
