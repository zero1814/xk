package org.product.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.repository.product.PcProductSpecificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcProductSpecificationTest {

	@Autowired
	private PcProductSpecificationRepository repository;

	@Test
	@Transactional
	public void all() {
		List<Object> list = repository.findProductSpecification("PP1140872842812846086");
		System.out.println(JSON.toJSONString(list));
	}
}