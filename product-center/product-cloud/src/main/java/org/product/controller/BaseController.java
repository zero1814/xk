package org.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.zero.spring.jpa.BaseEntity;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.PageResult;

public class BaseController<T extends BaseEntity, S extends IBaseService<T, String>> {

	@Autowired
	private S service;

	@PostMapping(value = "insert", consumes = "application/json")
	public BaseResult insert(@RequestBody T entity) {
		return service.insert(entity);
	}

	@PostMapping(value = "update", consumes = "application/json")
	public BaseResult update(@RequestBody T entity) {
		return service.update(entity, entity.getCode());
	}

	@GetMapping("get/{code}")
	public EntityResult<T> select(@PathVariable("code") String code) {
		EntityResult<T> result = service.select(code);
		return result;
	}

	@GetMapping("del/{code}")
	public BaseResult delete(@PathVariable("code") String code) {
		return service.delete(code);
	}

	@PostMapping(value = "all", consumes = "application/json")
	public DataResult<T> selectAll(@RequestBody T entity) {
		return service.selectAll(entity);
	}

	@PostMapping(value = "page", consumes = "application/json")
	public PageResult<T> page(@RequestBody T entity) {
		PageResult<T> result = service.page(entity);
		return result;
	}
}
