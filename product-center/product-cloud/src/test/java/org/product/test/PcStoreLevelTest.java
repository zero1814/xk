package org.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.store.PcStoreLevel;
import org.product.service.store.IPcStoreLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcStoreLevelTest {

	@Autowired
	private IPcStoreLevelService service;

	@Test
	public void page() {
		PcStoreLevel entity = new PcStoreLevel();
		entity.setFlagEnabled(1);
		entity.setPage(1);
		entity.setSize(10);
		JSON.toJSONString(service.page(entity));
	}
}
