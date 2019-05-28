package org.product.controller;

import org.zero.spring.jpa.BaseController;
import org.product.entity.PcKeyword;
import org.product.service.IPcKeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/keyword/")
@Api(tags = "关键字相关")
public class PcKeywordsController extends BaseController<PcKeyword, IPcKeywordsService> {

	@Autowired
	private IPcKeywordsService service;

	@ApiOperation("获取所有数据信息")
	@PostMapping(value = "all", consumes = "application/json")
	public WebResult all() {
		DataResult<PcKeyword> result = service.keywordAll();
		return WebResult.data(result);
	}
}
