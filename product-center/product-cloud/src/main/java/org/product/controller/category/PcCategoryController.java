package org.product.controller.category;

import org.zero.spring.jpa.BaseController;
import org.product.entity.category.PcCategory;
import org.product.service.category.IPcCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/category/")
@Api(tags = "商品分类相关")
public class PcCategoryController extends BaseController<PcCategory, IPcCategoryService> {

	@Autowired
	private IPcCategoryService service;

	@PostMapping("parent")
	public WebResult findParent(@RequestBody String code) {
		DataResult<PcCategory> result = service.findParent(code);
		return WebResult.data(result);
	}
}
