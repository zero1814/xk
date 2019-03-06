package org.product.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.product.PcLabel;
import org.product.service.product.IPcLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcLabelTest {

	@Autowired
	private IPcLabelService service;

	@Test
	public void save() {
		PcLabel entity = new PcLabel();
		entity.setCode(CodeHelper.getCode("PL"));
		entity.setName("衣服");
		entity.setCreateUser("admin");
		service.insert(entity);
	}
}
