package org.product.controller.category;

import org.product.controller.FlagEnabledController;
import org.product.entity.category.PcCategory;
import org.product.service.category.IPcCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/category/")
@Api(tags = "商品分类相关")
public class PcCategoryController extends FlagEnabledController<PcCategory, IPcCategoryService> {

	@Autowired
	private IPcCategoryService service;

	@PostMapping("parent")
	public WebResult findParent(String code) {
		DataResult<PcCategory> result = service.findParent(code);
		return WebResult.data(result);
	}
}
