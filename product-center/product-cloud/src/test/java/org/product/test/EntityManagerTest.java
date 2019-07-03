package org.product.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class EntityManagerTest {

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Test
	public void select() {
		String hql = "select ps from PcSku ps  where ps.code='PS1140872842989006848' ";
		try {
			List<Object> list = em.createQuery(hql).getResultList();
			System.out.println(JSON.toJSONString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
