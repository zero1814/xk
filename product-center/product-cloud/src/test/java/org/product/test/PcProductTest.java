package org.product.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductSpecification;
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
	private PcProductRepository repository;

	@Autowired
	private IPcProductService service;

	@Transactional
	public void get() {
		PcProduct product = repository.getProduct("12321");
		System.out.println(JSON.toJSONString(product));
	}

	@Transactional
	public void specification() {
		System.out.println(JSON.toJSONString(service.getAttribute("PP1145585963376832513")));
	}

	@Test
	@Transactional
	public void attribute() {
		// System.out.println(JSON.toJSONString(service.getSpecification("PP1143060242133676032")));
		List<PcProductSpecification> specs = repository.findProductSpecificationData("PP1145585963376832513");
		System.out.println(JSON.toJSONString(specs));
	}

	@Transactional
	public void sku() {
		String code = "PP1143321214962364423";
		System.out.println(JSON.toJSONString(service.getSkuList(code)));
	}
}
