package org.product.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.controller.category.PcCategoryController;
import org.product.entity.category.PcCategory;
import org.product.entity.category.PcCategoryParam;
import org.product.query.PcCategoryQuery;
import org.product.repository.category.PcCategoryRepository;
import org.product.service.category.IPcCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.result.EntityResult;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcCategoryTest {

	@Autowired
	private IPcCategoryService service;
	@Autowired
	private PcCategoryController controller;
	@Autowired
	private PcCategoryQuery query;
	@Autowired
	private PcCategoryRepository repository;

	public void create() {
		PcCategory entity = new PcCategory();
		entity.setName("测试分类");
		entity.setCreateUser("admin");
		List<PcCategoryParam> params = new ArrayList<PcCategoryParam>();
		PcCategoryParam param = new PcCategoryParam();
		param.setName("测试分类属性");
		param.setSort(Long.valueOf(1));
		params.add(param);
		entity.setParams(params);
		EntityResult<PcCategory> result = service.create(entity);
		System.out.println(JSON.toJSONString(result));
	}

	@Test
	public void get() {
		// WebResult reuslt = controller.select("PC1130401130858147840");
		// System.out.println(JSON.toJSONString(reuslt));
		List<PcCategory> list = repository.parent("");
		System.out.println(JSON.toJSONString(list));
	}
}
