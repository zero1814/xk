package org.product.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
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
	private PcProductRepository repository;

	@Test
	@Transactional
	public void get() {
		PcProduct product = repository.getProduct("12321");
		System.out.println(JSON.toJSONString(product));
	}

}
