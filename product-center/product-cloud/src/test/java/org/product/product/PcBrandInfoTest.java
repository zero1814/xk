package org.product.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.product.PcBrandInfo;
import org.product.service.product.IPcBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcBrandInfoTest {

	@Autowired
	private IPcBrandInfoService service;

	@Test
	public void save() {
		PcBrandInfo entity = new PcBrandInfo();
		entity.setCode(CodeHelper.getCode("PB"));
		entity.setName("花花公子");
		entity.setEnName("playboy");
		entity.setCreateUser("admin");
		service.insert(entity);
	}
}
