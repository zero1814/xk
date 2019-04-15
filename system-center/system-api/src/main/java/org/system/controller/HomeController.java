package org.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.entity.user.ScUserInfo;
import org.system.result.HomeResult;
import org.system.service.user.IScUserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;

@Api(tags = "公用接口")
@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private IScUserInfoService userService;

	@ApiOperation("首页")
	@GetMapping("home")
	public HomeResult home() {
		return new HomeResult();
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
	@ApiOperation("用户登录")
	@PostMapping(value = "login", consumes = "application/json")
	public EntityResult<ScUserInfo> login(@RequestBody ScUserInfo entity) {
		return userService.select(entity);
	}

	/**
	 * 
	 * 方法: register <br>
	 * 描述: 用户注册 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月12日 上午8:49:35
	 * 
	 * @param entity
	 * @return
	 */
	@ApiOperation("用户注册")
	@PostMapping(value = "register", consumes = "application/json")
	public EntityResult<ScUserInfo> register(@RequestBody ScUserInfo entity) {
		return userService.insert(entity);
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
	@ApiOperation("用户注销")
	@GetMapping("logout/{userCode}")
	public BaseResult logout(@PathVariable("userCode") String userCode) {
		return userService.logout(userCode);
	}
}
