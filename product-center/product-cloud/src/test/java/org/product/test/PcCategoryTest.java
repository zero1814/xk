package org.product.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.category.PcCategory;
import org.product.entity.category.PcCategoryAttribute;
import org.product.service.category.IPcCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.result.EntityResult;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcCategoryTest {

	@Autowired
	private IPcCategoryService service;

	@Test
	public void create() {
		PcCategory entity = new PcCategory();
		entity.setName("测试分类");
		entity.setCreateUser("admin");
		List<PcCategoryAttribute> attributes = new ArrayList<PcCategoryAttribute>();
		PcCategoryAttribute attr = new PcCategoryAttribute();
		attr.setName("测试分类属性");
		attributes.add(attr);
		entity.setAttributes(attributes);
		EntityResult<PcCategory> result = service.create(entity);
		System.out.println(JSON.toJSONString(result));
	}
}
