package org.product.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.store.PcStoreInfo;
import org.product.repository.store.PcStoreInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcStoreInfoTest {

	@Autowired
	private PcStoreInfoRepository repository;

	@Test
	public void find() {
		String code = "dsfdsfdfdf";
		PcStoreInfo entity = repository.getOne(code);
		System.out.println(JSON.toJSONString(entity));
	}
}
