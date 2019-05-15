package org.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.label.PcLabelType;
import org.product.service.label.IPcLabelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcLabelTypeTest {
	
	@Autowired
	private IPcLabelTypeService service;
	
	@Test
	public void create() {

		String [] labels = new String[] {"商品","店铺","活动"};
		for (String name : labels) {
			PcLabelType type = new PcLabelType();
			type.setName(name);
			type.setCreateUser("admin");
			service.create(type);
		}
	}
}
