package org.product.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.store.PcStoreStatus;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcStoreStatusTest {

	@Autowired
	private IPcStoreStatusService service;

	@Test
	public void insert() {
		String [] statusList = new String[] {"正常","冻结","注销"}; 
		for (String status : statusList) {
			PcStoreStatus entity = new PcStoreStatus();
			entity.setUid(CodeHelper.getUUID());
			entity.setCode(CodeHelper.getCode("SS"));
			entity.setName(status);
			entity.setCreateUser("insert");
			service.insert(entity);
		}
	}
}
