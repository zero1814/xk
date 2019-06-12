package org.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.controller.product.PcProductController;
import org.product.entity.product.PcProduct;
import org.product.repository.product.PcProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcProductTest {

	@Autowired
	private PcProductController controller;
	@Autowired
	private PcProductRepository repository;

	public void page() {
		PcProduct entity = new PcProduct();
		entity.setPage(1);
		entity.setSize(10);
		System.out.println(JSON.toJSON(controller.page(entity)));
	}

	@Test
	public void delete() {
		String[] ids = new String[] { "PP1138739098589065216" };
		for (String id : ids) {
			repository.deleteById(id);
		}
	}
}
