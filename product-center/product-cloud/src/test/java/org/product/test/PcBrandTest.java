package org.product.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.PcBrand;
import org.product.service.IPcBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcBrandTest {

	String pic = "http://xk-mall.oss-cn-beijing.aliyuncs.com/xk-mall/images//30063f04833ce15bd93d8d4c3c36eb7f.png";

	@Autowired
	private IPcBrandService service;

	@Test
	public void create() {
		String [] names = new String[] {"华为","apple","vivo","小米"};
		for (String name : names) {
			PcBrand entity = new PcBrand();
			entity.setName(name);
			entity.setLogo(pic);
			entity.setIcon(pic);
			entity.setCreateUser("admin");
			service.create(entity);
		}
	}
}
