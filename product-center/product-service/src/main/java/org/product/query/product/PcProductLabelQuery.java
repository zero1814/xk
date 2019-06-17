package org.product.query.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.product.entity.PcLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PcProductLabelQuery {
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<PcLabel> labels(String product) {
		List<PcLabel> list = null;
		try {
			Query query = em.createNativeQuery(
					"select l.code,l.name from pc_product_label as ppl LEFT JOIN pc_label as l ON ppl.label = l.code where ppl.product=:product");
			query.setParameter("product", product);
			List<Object> result = query.getResultList();
			if (result.isEmpty()) {
				return null;
			}
			list = new ArrayList<PcLabel>();
			for (Object object : result) {
				Object[] objData = (Object[]) object;
				PcLabel label = new PcLabel();
				label.setCode(objData[0].toString());
				label.setName(objData[1].toString());
				list.add(label);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查询商品标签报错：\n" + e.getLocalizedMessage());
		}
		return list;

	}
}
