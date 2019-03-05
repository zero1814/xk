package org.product.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.product.PcBrandInfo;
import org.product.service.product.IPcBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.result.PageResult;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcBrandInfoTest {

	@Autowired
	private IPcBrandInfoService service;

	@Test
	public void page() {
		PcBrandInfo entity = new PcBrandInfo();
		entity.setPage(1);
		entity.setSize(10);
		PageResult<PcBrandInfo> result = service.page(entity);
		System.out.println(JSON.toJSON(result));
	}
}
