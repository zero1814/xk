package org.product.controller;

import org.zero.spring.jpa.BaseController;
import org.product.entity.PcBrand;
import org.product.service.IPcBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/brand/")
@Api(tags = "商品品牌相关")
public class PcBrandController extends BaseController<PcBrand, IPcBrandService> {

	@Autowired
	private IPcBrandService service;

	@ApiOperation("获取所有数据信息")
	@GetMapping(value = "all")
	public WebResult all() {
		DataResult<PcBrand> result = service.brandAll();
		return WebResult.data(result);
	}
}
