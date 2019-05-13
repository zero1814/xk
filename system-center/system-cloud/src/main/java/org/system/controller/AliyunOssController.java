package org.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.component.IOssClientComponent;
import org.system.entity.extend.OssCallback;
import org.system.entity.extend.OssPolicy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.WebResult;

@Api(tags = "阿里云操作接口")
@RestController
@RequestMapping("aliyun/oss/")
public class AliyunOssController {

	@Autowired
	private IOssClientComponent component;

	@ApiOperation(value = "oss上传签名生成")
	@GetMapping("policy")
	public WebResult policy() {
		String path = "/system/";
		EntityResult<OssPolicy> result = component.policy(path);
		return WebResult.obj(result);
	}

	@ApiOperation(value = "oss上传成功回调")
	@PostMapping("callback")
	public WebResult callback(HttpServletRequest request) {
		EntityResult<OssCallback> result = component.callback(request);
		return WebResult.obj(result);
	}
}
