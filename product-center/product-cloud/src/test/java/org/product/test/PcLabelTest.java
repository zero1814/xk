package org.product.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.PcLabel;
import org.product.repository.label.PcLabelRepository;
import org.product.service.label.IPcLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcLabelTest {

	@Autowired
	private IPcLabelService service;
	@Autowired
	private PcLabelRepository respository;

	@Test
	public void create() {
		String[] values = new String[] { "自营", "推荐", "满减" };
		int i = 1;
		for (String val : values) {
			PcLabel entity = new PcLabel();
			entity.setType(1);
			entity.setName(val);
			entity.setFlagEnabled(0);
			entity.setSort(Long.valueOf(i));
			entity.setCreateUser("admin");
			service.create(entity);
			i++;
		}
	}

	public void all() {
		List<PcLabel> list = respository.all(1);
		System.out.println(JSON.toJSONString(list));
	}
}
