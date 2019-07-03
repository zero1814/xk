package org.product.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.category.PcCategory;
import org.product.entity.category.PcCategoryAttribute;
import org.product.entity.category.PcCategorySpecification;
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

	@Test
	public void create() {
		List<PcCategorySpecification> specificationData = new ArrayList<PcCategorySpecification>();
		PcCategorySpecification pcs = new PcCategorySpecification();
		pcs.setName("内存");
		pcs.setValue("4G,6G,8G");
		pcs.setSort(0);
		specificationData.add(pcs);
		List<PcCategoryAttribute> attributeData = new ArrayList<PcCategoryAttribute>();
		PcCategoryAttribute attribute = new PcCategoryAttribute();
		attribute.setName("内存");
		attribute.setValue("4G,6G,8G");
		attribute.setSort(0);
		attributeData.add(attribute);
		String[] names = new String[] { "手机", "电脑", "平板" };
		for (String name : names) {
			PcCategory entity = new PcCategory();
			entity.setName(name);
			entity.setFlagEnabled(0);
			entity.setSort(0);
			entity.setCreateUser("admin");
			entity.setAttributeList(attributeData);
			entity.setSepcList(specificationData);
			entity.setCreateUser("admin");
			service.create(entity);
		}
	}

	public void page() {
		PcCategory entity = new PcCategory();
		entity.setPage(1);
		entity.setSize(10);
		System.out.println(JSON.toJSONString(service.page(entity)));
	}

	public void getSpecifications() {
		System.out.println(JSON.toJSONString(specRepository.getCategorySpecifications("PC1133902595870420992")));
		// System.out.println(JSON.toJSONString(service.getSpecifications("PC1133902595870420992")));
	}

	public void getAttributes() {
		System.out.println(JSON.toJSONString(service.getAttributes("PC1133902595870420992")));
	}
}
