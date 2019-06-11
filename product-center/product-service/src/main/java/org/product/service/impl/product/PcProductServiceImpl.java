package org.product.service.impl.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.product.entity.PcAlbum;
import org.product.entity.PcBrand;
import org.product.entity.category.PcCategory;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductStatus;
import org.product.entity.product.PcSku;
import org.product.entity.store.PcStore;
import org.product.repository.product.PcProductRepository;
import org.product.service.IPcAlbumService;
import org.product.service.product.IPcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.DateUtil;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.PageResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcProductServiceImpl <br>
 * 描述: 商品业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:18
 */
@Slf4j
@Service
public class PcProductServiceImpl extends BaseServiceImpl<PcProduct, String, PcProductRepository>
		implements IPcProductService {
	@Autowired
	private IPcAlbumService albumService;
	@Autowired
	private EntityManager em;

	@Override
	@Transactional
	public EntityResult<PcProduct> create(PcProduct entity) {
		EntityResult<PcProduct> result = new EntityResult<PcProduct>();
		if (entity.getAlbum() != null) {
			EntityResult<PcAlbum> _result = albumService.create(entity.getAlbum());
			if (_result.getCode() != ResultType.SUCCESS) {
				result.setCode(_result.getCode());
				result.setMessage(_result.getMessage());
				return result;
			}
			entity.setAlbum(_result.getEntity());
		}
		BigDecimal minSellPrice = new BigDecimal(0.00);
		BigDecimal maxSellPrice = new BigDecimal(0.00);
		if (!entity.getSkuList().isEmpty() && entity.getSkuList().size() > 0) {
			minSellPrice = entity.getSkuList().get(0).getSellPrice();
			maxSellPrice = entity.getSkuList().get(0).getSellPrice();
			for (PcSku sku : entity.getSkuList()) {
				if (sku.getSellPrice().compareTo(minSellPrice) == -1) {
					minSellPrice = sku.getSellPrice();
				} else if (sku.getSellPrice().compareTo(maxSellPrice) == 1) {
					maxSellPrice = sku.getSellPrice();
				}
			}
		}
		entity.setMinSellPrice(minSellPrice);
		entity.setMaxSellPrice(maxSellPrice);
		return super.create(entity);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageResult<PcProduct> page(PcProduct entity) {
		PageResult<PcProduct> result = new PageResult<PcProduct>();
		try {
			log.info("------------>查询商品列表");
			String selectSql = pageSql(entity, 0);
			Query query = em.createNativeQuery(selectSql);
			// 分页
			int start = (entity.getPage() - 1) * entity.getSize();
			int size = entity.getSize();
			query.setFirstResult(start);
			query.setMaxResults(size);
			query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			List<Object> list = query.getResultList();
			if (list.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询为空");
				return result;
			}
			List<PcProduct> products = new ArrayList<PcProduct>();
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
				products.add(product);
			}
			// 获取查询总数
			String totalSql = pageSql(entity, 1);
			Object totalObject = em.createNativeQuery(totalSql).getSingleResult();
			Long total = Long.valueOf(totalObject.toString());
			result.setData(products);
			result.setTotal(total);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询报错");
		}
		log.info("处理结果" + JSON.toJSONString(result));
		return result;
	}

	private String pageSql(PcProduct entity, int type) {
		StringBuffer sql = new StringBuffer();
		if (type == 0) {
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
			sql.append(" and s.code = " + entity.getStatus().getCode());
		} else if (entity.getBrand() != null && StringUtils.isNotBlank(entity.getBrand().getCode())) {
			sql.append(" and b.code = " + entity.getBrand().getCode());
		} else if (entity.getCategory() != null && StringUtils.isNotBlank(entity.getCategory().getCode())) {
			sql.append(" and c.code = " + entity.getCategory().getCode());
		} else if (entity.getStore() != null && StringUtils.isNotBlank(entity.getStore().getCode())) {
			sql.append(" and store.code = " + entity.getStore().getCode());
		}
		log.info("执行分页查询数据sql:\n" + sql);
		return sql.toString();
	}
}
