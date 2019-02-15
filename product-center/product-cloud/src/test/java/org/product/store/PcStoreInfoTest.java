package org.product.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.store.PcStoreInfo;
import org.product.entity.store.PcStoreStatus;
import org.product.entity.store.PcStoreType;
import org.product.service.store.IPcStoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zero.commons.test.RandomValue;

import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcStoreInfoTest {

	@Autowired
	private IPcStoreInfoService service;

	@Test
	public void save() {
		for (int i = 0; i < 10000; i++) {
			PcStoreInfo entity = new PcStoreInfo();
			entity.setUid(CodeHelper.getUUID());
			entity.setCode(CodeHelper.getCode("S"));
			entity.setName("测试店铺-" + i);
			PcStoreType type = new PcStoreType();
			type.setCode("SS1096255876152422400");
			entity.setType(type);
			entity.setPrincipalName(RandomValue.getCname());
			entity.setPrincipalPhone(RandomValue.getPhone());
			entity.setIconUrl("123");
			PcStoreStatus status = new PcStoreStatus();
			status.setCode("SS1096252825274413056");
			entity.setStatus(status);
			entity.setCreateUser("insert");
			service.insert(entity);
		}
	}
}
