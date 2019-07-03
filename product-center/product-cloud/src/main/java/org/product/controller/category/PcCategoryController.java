package org.product.controller.category;

import org.zero.spring.jpa.BaseController;
import org.product.entity.category.PcCategory;
import org.product.entity.category.PcCategoryAttribute;
import org.product.entity.category.PcCategorySpecification;
import org.product.service.category.IPcCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/category/")
@Api(tags = "商品分类相关")
public class PcCategoryController extends BaseController<PcCategory, IPcCategoryService> {

	@Autowired
	private IPcCategoryService service;

	@ApiOperation("查询父级商品分类")
	@PostMapping("parent")
	public WebResult findParent(@RequestBody String code) {
		DataResult<PcCategory> result = service.findParent(code);
		return WebResult.data(result);
	}

	@ApiOperation("查询可用商品分类")
	@GetMapping("all")
	public WebResult all() {
		DataResult<PcCategory> result = service.categoryData();
		return WebResult.data(result);
	}

	@ApiOperation("根据商品分类编码查询商品规格参数列表")
	@GetMapping("specification/{category}")
	public WebResult getSpecifications(@PathVariable("category") String category) {
		DataResult<PcCategorySpecification> result = service.getSpecifications(category);
		return WebResult.data(result);
	}

	@ApiOperation("根据商品分类编码查询商品属性参数列表")
	@GetMapping("attribute/{category}")
	public WebResult getAttributes(@PathVariable("category") String category) {
		DataResult<PcCategoryAttribute> result = service.getAttributes(category);
		return WebResult.data(result);
	}
}
