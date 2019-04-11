package org.system.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.BaseController;
import org.system.entity.user.ScUserInfo;
import org.system.result.user.ScUserPropertyResult;
import org.system.service.user.IScUserInfoService;

import io.swagger.annotations.Api;

/**
 * 
 * 类: ScUserInfoController <br>
 * 描述: 系统用户接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:52:16
 */
@Api(tags="系统用户管理")
@RestController
@RequestMapping("/system/user/")
public class ScUserInfoController extends BaseController<ScUserInfo, IScUserInfoService> {
	@Autowired
	private IScUserInfoService service;

	@GetMapping(value = "init/params")
	public ScUserPropertyResult property() {
		return service.initProperty();
	}
}
