package org.product.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.product.PcProductStatus;
import org.product.repository.product.PcProductStatusRepository;
import org.product.service.product.IPcProductStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcProductStatusTest {

	@Autowired
	private IPcProductStatusService service;

	@Autowired
	private PcProductStatusRepository repository;

	@Test
	public void create() {
		String[] values = new String[] { "未上架", "已上架", "已下架", "已售罄" };
		for (String val : values) {
			PcProductStatus entity = new PcProductStatus();
			entity.setName(val);
			entity.setCreateUser("admin");
			service.create(entity);
		}
	}

	public void all() {
		List<PcProductStatus> list = repository.all();
		System.out.println(JSON.toJSONString(list));
	}
}
