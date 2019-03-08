package org.product.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.store.PcStoreType;
import org.product.service.store.IPcStoreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcStoreTypeTest {

	@Autowired
	private IPcStoreTypeService service;

	@Test
	public void save() {
		String[] types = new String[] { "个人", "私营", "企业" };
		for (String type : types) {
			PcStoreType entity = new PcStoreType();
			entity.setUid(CodeHelper.getUUID());
			entity.setCode(CodeHelper.getCode("SS"));
			entity.setName(type);
			entity.setCreateUser("insert");
			service.insert(entity);
		}
	}
}
