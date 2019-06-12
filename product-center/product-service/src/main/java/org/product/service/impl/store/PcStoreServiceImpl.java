package org.product.service.impl.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.product.entity.store.PcStore;
import org.product.entity.store.PcStoreLevel;
import org.product.entity.store.PcStoreStatus;
import org.product.repository.store.PcStoreRepository;
import org.product.service.store.IPcStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.PageResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcStoreServiceImpl <br>
 * 描述: 店铺业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:18
 */
@Service
public class PcStoreServiceImpl extends BaseServiceImpl<PcStore, String, PcStoreRepository> implements IPcStoreService {

	@Autowired
	private EntityManager em;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageResult<PcStore> page(PcStore entity) {
		PageResult<PcStore> result = new PageResult<PcStore>();
		try {
			List<PcStore> stores = new ArrayList<PcStore>();
			String selectSql = pageSql(entity, 0);
			if (StringUtils.isBlank(selectSql)) {
				result.setCode(ResultType.ERROR);
				result.setMessage("执行查询sql失败");
				return result;
			}
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
			for (Object object : list) {
				Map map = (Map) object;
				PcStore store = new PcStore();
				store.setCode(map.get("code").toString());
				store.setName(map.get("name").toString());
				store.setIcon(map.get("icon").toString());
				PcStoreLevel level = new PcStoreLevel();
				level.setName(map.get("level").toString());
				store.setLevel(level);
				PcStoreStatus status = new PcStoreStatus();
				status.setName(map.get("status").toString());
				store.setStatus(status);
				stores.add(store);
			}
			// 获取查询总数
			String totalSql = pageSql(entity, 1);
			Object totalObject = em.createNativeQuery(totalSql).getSingleResult();
			Long total = Long.valueOf(totalObject.toString());
			result.setData(stores);
			result.setTotal(total);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private String pageSql(PcStore entity, Integer type) {
		StringBuffer sql = new StringBuffer("select ");
		try {
			if (type == 0) {
				sql.append(" ps.code,ps.name,ps.icon,psl.name AS level,pss.name AS status");
			} else {
				sql.append(" count(1) ");
			}
			sql.append(" FROM pc_store AS ps");
			sql.append(" LEFT JOIN pc_store_level AS psl ON ps.level = psl.code");
			sql.append(" LEFT JOIN pc_store_status AS pss ON ps.status = pss.code");
			sql.append(" WHERE 1=1 ");
			if (StringUtils.isNotBlank(entity.getName())) {
				sql.append(" AND ps.name like CONCAT('%','" + entity.getName() + "','%')");
			} else if (entity.getLevel() != null && StringUtils.isNotBlank(entity.getLevel().getCode())) {
				sql.append(" AND psl.code = '" + entity.getLevel().getCode() + "'");
			} else if (entity.getStatus() != null && StringUtils.isNotBlank(entity.getStatus().getCode())) {
				sql.append(" AND pss.code = '" + entity.getStatus().getCode() + "'");
			}
			return sql.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
