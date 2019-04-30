package org.product.controller;

import org.product.entity.FlagEnabledEntity;
import org.product.service.IFlagEnabledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.BaseResult;

public class FlagEnabledController<T extends FlagEnabledEntity, S extends IFlagEnabledService<T, String>>
		extends BaseController<T, S> {

	@Autowired
	private S service;

	@ApiOperation("修改可用状态")
	@PostMapping(value = "update/flag_enabled", consumes = "application/json")
	public BaseResult updateFlagEnabled(@RequestBody T entity) {
		return service.updateFlagEnabled(entity);
	}
}
