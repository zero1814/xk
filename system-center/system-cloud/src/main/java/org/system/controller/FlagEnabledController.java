package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.system.entity.FlagEnabledEntity;
import org.system.service.IFlagEnabledService;

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
