package org.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.file.entity.OssCallback;
import org.file.entity.OssPolicy;
import org.file.service.IOssClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.WebResult;

@Api(tags = "阿里云操作接口")
@RestController
@RequestMapping("aliyun/oss/")
public class AliyunOssController {
	@Autowired
	private IOssClientService service;

	@ApiOperation(value = "oss上传签名生成")
	@GetMapping("policy")
	public WebResult policy(@RequestParam("path") String path) {
		EntityResult<OssPolicy> result = service.policy(path);
		return WebResult.obj(result);
	}

	@ApiOperation(value = "oss上传成功回调")
	@PostMapping("callback")
	public WebResult callback(HttpServletRequest request) {
		EntityResult<OssCallback> result = service.callback(request);
		return WebResult.obj(result);
	}
}
