package org.product.controller.product;

import org.product.service.product.IPcSkuStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

import org.zero.spring.jpa.BaseController;
import org.product.entity.product.PcSkuStatus;

@RestController
@RequestMapping("/product/sku/status/")
@Api(tags = "商品sku状态相关")
public class PcSkuStatusController extends BaseController<PcSkuStatus, IPcSkuStatusService> {

	@Autowired
	private IPcSkuStatusService service;

	@ApiOperation("获取所有数据信息")
	@PostMapping(value = "all", consumes = "application/json")
	public WebResult all() {
		DataResult<PcSkuStatus> result = service.statusAll();
		return WebResult.data(result);
	}
}
