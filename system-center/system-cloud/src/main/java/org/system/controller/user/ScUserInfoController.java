package org.system.controller.user;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.BaseController;
import org.system.dto.LoginParam;
import org.system.entity.user.ScUserInfo;
import org.system.jwt.JwtTokenUtil;
import org.system.service.user.IScUserInfoService;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;
import zero.commons.basics.result.WebResult;

/**
 * 
 * 类: ScUserInfoController <br>
 * 描述: 系统用户接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:52:16
 */
@Api(tags = "系统用户管理")
@RestController
@RequestMapping("/user/")
public class ScUserInfoController extends BaseController<ScUserInfo, IScUserInfoService> {
	@Autowired
	private IScUserInfoService service;
	@Autowired
	private RedisTemplate<String, String> template;
	@Autowired
	private JwtTokenUtil jwtUtil;

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
	public WebResult login(@RequestBody LoginParam param) {
		EntityResult<ScUserInfo> _result = service.login(param);
		if (_result.getCode() == ResultType.SUCCESS) {
			String token = jwtUtil.generateToken(_result.getEntity());
			JSONObject obj = (JSONObject) JSONObject.toJSON(_result.getEntity());
			template.opsForValue().set(token, obj.toJSONString(), Duration.ofDays(30));
			return WebResult.success("登录成功");
		} else {
			return WebResult.error("登录成功");
		}
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
	public WebResult register(@RequestBody ScUserInfo entity) {
		EntityResult<ScUserInfo> result = service.create(entity);
		return WebResult.obj(result);
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
	@GetMapping("logout/{code}")
	public WebResult logout(@PathVariable("code") String userCode) {
		BaseResult result = service.logout(userCode);
		return WebResult.result(result);
	}
}
