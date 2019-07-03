package org.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.store.PcStoreStatus;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcStoreStatusTest {

	@Autowired
	private IPcStoreStatusService service;

	@Test
	public void create() {
		String[] statusList = new String[] { "正常", "已注销" };
		for (String name : statusList) {
			PcStoreStatus entity = new PcStoreStatus();
			entity.setName(name);
			entity.setFlagEnabled(0);
			entity.setType(2);
			entity.setCreateUser("admin");
			service.create(entity);
		}
	}
}
