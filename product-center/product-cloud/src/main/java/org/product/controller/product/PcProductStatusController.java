package org.product.controller.product;

import org.zero.spring.jpa.BaseController;
import org.product.entity.product.PcProductStatus;
import org.product.service.product.IPcProductStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/product/status/")
@Api(tags = "商品状态相关")
public class PcProductStatusController extends BaseController<PcProductStatus, IPcProductStatusService> {

	@Autowired
	private IPcProductStatusService service;

	@ApiOperation("获取所有数据信息")
	@GetMapping(value = "all")
	public WebResult selectAll(@RequestParam("type") Integer type) {
		DataResult<PcProductStatus> result = service.statusAll(type);
		return WebResult.data(result);
	}
}
