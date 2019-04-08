package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.system.entity.user.ScUserInfo;
import org.system.result.HomeResult;
import org.system.service.user.IScUserInfoService;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;

@RestController
public class HomeController {
	@Autowired
	private IScUserInfoService userService;

	@GetMapping("/home")
	public HomeResult home() {
		return null;
	}

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 用户登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月8日 上午11:46:16
	 * 
	 * @param entity
	 * @return
	 */
	@PostMapping(value = "login", consumes = "application/json")
	public EntityResult<ScUserInfo> login(@RequestBody ScUserInfo entity) {
		return userService.select(entity);
	}

	/**
	 * 
	 * 方法: logout <br>
	 * 描述: 用户登出 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月8日 上午11:46:04
	 * 
	 * @param userCode
	 * @return
	 */
	@GetMapping("/logout/{userCode}")
	public BaseResult logout(@PathVariable("userCode") String userCode) {
		return userService.logout(userCode);
	}
}
