package org.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.controller.product.PcProductController;
import org.product.entity.product.PcProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcProductTest {

	@Autowired
	private PcProductController controller;

	@Test
	public void page() {
		PcProduct entity = new PcProduct();
		entity.setPage(1);
		entity.setSize(10);
		System.out.println(JSON.toJSON(controller.page(entity)));
	}
}
