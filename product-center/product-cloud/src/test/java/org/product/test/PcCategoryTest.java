package org.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.category.PcCategory;
import org.product.repository.category.PcCategorySpecificationRepository;
import org.product.service.category.IPcCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcCategoryTest {

	@Autowired
	private IPcCategoryService service;
	@Autowired
	private PcCategorySpecificationRepository specRepository;

	public void page() {
		PcCategory entity = new PcCategory();
		entity.setPage(1);
		entity.setSize(10);
		System.out.println(JSON.toJSONString(service.page(entity)));
	}

	@Test
	public void getSpecifications() {
		System.out.println(JSON.toJSONString(specRepository.getCategorySpecifications("PC1133902595870420992")));
		// System.out.println(JSON.toJSONString(service.getSpecifications("PC1133902595870420992")));
	}

	public void getAttributes() {
		System.out.println(JSON.toJSONString(service.getAttributes("PC1133902595870420992")));
	}
}
