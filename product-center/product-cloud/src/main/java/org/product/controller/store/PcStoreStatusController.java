package org.product.controller.store;

import org.zero.spring.jpa.BaseController;
import org.product.entity.store.PcStoreStatus;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/store/status/")
@Api(tags = "店铺状态相关")
public class PcStoreStatusController extends BaseController<PcStoreStatus, IPcStoreStatusService> {

	@Autowired
	private IPcStoreStatusService service;

	@ApiOperation("获取所有数据信息")
	@GetMapping(value = "all")
	public WebResult all() {
		DataResult<PcStoreStatus> result = service.statusAll();
		return WebResult.data(result);
	}
}
