package org.product.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcSku;
import org.product.repository.product.PcProductRepository;
import org.product.service.product.IPcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcProductTest {

	@Autowired
	private IPcProductService service;
	@Autowired
	private PcProductRepository repository;

	public void getSpecification() {
		System.out.println(JSON.toJSONString(service.getSpecification("PP1140872842812846086")));
	}

	public void getAttribute() {
		System.out.println(JSON.toJSONString(service.getAttribute("PP1140872842812846086")));
	}

	@Test
	@Transactional
	public void sku() {
		long start = System.currentTimeMillis();
		List<PcSku> list = repository.findSkuList("PP1140872842812846086");
		System.out.println(JSON.toJSONString(list));
		long end = System.currentTimeMillis();
		System.out.println("执行时间:" + (end - start) + "s");
	}

	public void getProduct() {
		long start = System.currentTimeMillis();
		String code = "PP1140872842812846086";
		PcProduct product = repository.getProduct(code);
		System.out.println(JSON.toJSONString(product));
		long end = System.currentTimeMillis();
		System.out.println("执行时间:" + (end - start) + "s");

	}
}
