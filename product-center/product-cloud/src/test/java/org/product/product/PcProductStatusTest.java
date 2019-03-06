package org.product.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.product.PcProductStatus;
import org.product.service.product.IPcProductStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.DataResult;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcProductStatusTest {

	@Autowired
	private IPcProductStatusService service;

	public void save() {
		PcProductStatus entity = new PcProductStatus();
		entity.setCode(CodeHelper.getCode("PS"));
		entity.setName("已下架");
		entity.setCreateUser("save");
		service.insert(entity);
	}

	@Test
	public void all() {
		DataResult<PcProductStatus> result = service.selectAll(new PcProductStatus());
		System.out.println(JSON.toJSON(result));
	}
}
