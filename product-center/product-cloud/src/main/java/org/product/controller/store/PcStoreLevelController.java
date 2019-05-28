package org.product.controller.store;

import org.zero.spring.jpa.BaseController;
import org.product.entity.store.PcStoreLevel;
import org.product.service.store.IPcStoreLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/store/level/")
@Api(tags = "店铺等级相关")
public class PcStoreLevelController extends BaseController<PcStoreLevel, IPcStoreLevelService> {

	@Autowired
	private IPcStoreLevelService service;

	@ApiOperation("获取所有数据信息")
	@PostMapping(value = "all", consumes = "application/json")
	public WebResult all() {
		DataResult<PcStoreLevel> result = service.levelAll();
		return WebResult.data(result);
	}
}
