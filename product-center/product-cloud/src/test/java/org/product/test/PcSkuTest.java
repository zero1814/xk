package org.product.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.product.PcSku;
import org.product.repository.product.PcSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcSkuTest {

	@Autowired
	private PcSkuRepository repository;

	@Test
	@Transactional
	public void select() {
		long start = System.currentTimeMillis();
		PcSku sku = repository.getOne("PS1140872842989006848");
		long end = System.currentTimeMillis();
		System.out.println(JSON.toJSONString(sku));
		System.out.println("执行时间:" + (end - start) + "s");
	}
}
