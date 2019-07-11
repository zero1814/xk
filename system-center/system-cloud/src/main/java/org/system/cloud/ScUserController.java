package org.system.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.entity.ScUser;
import org.system.service.IScUserService;
import org.zero.spring.jpa.BaseController;

import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/user/")
public class ScUserController extends BaseController<ScUser, IScUserService> {

	@Autowired
	private IScUserService service;

	@GetMapping("get/{userName}")
	public WebResult findUserByUserName(@PathVariable("userName") String userName) {
		return WebResult.obj(service.findByUserName(userName));
	}
}
