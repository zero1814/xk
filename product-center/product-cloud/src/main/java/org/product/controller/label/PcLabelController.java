package org.product.controller.label;

import org.zero.spring.jpa.BaseController;
import org.product.entity.PcLabel;
import org.product.service.label.IPcLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/label/")
@Api(tags = "商品标签相关")
public class PcLabelController extends BaseController<PcLabel, IPcLabelService> {

	@Autowired
	private IPcLabelService service;

	@ApiOperation("根据类型查询可用标签列表")
	@GetMapping("all/{type}")
	public WebResult labelAll(@PathVariable("type") Integer type) {
		DataResult<PcLabel> result = service.labels(type);
		return WebResult.data(result);
	}
}
