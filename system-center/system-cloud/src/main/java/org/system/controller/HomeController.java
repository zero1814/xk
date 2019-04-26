package org.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.result.HomeResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "公用接口")
@RestController
@RequestMapping("/")
public class HomeController {

	@ApiOperation("首页")
	@GetMapping("home")
	public HomeResult home() {
		return new HomeResult();
	}
}
