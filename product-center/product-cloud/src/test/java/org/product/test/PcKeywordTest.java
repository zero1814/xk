package org.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.PcKeyword;
import org.product.service.IPcKeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcKeywordTest {

	@Autowired
	private IPcKeywordsService service;

	@Test
	public void create() {
		String[] names = new String[] { "自营", "满减", "促销" };
		for (String name : names) {
			PcKeyword entity = new PcKeyword();
			entity.setName(name);
			entity.setFlagEnabled(0);
			entity.setCreateUser("admin");
			service.create(entity);
		}
	}
}
