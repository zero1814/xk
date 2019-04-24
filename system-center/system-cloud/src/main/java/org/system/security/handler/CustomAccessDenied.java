package org.system.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.ServerUtil;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: CustomAccessDenied <br>
 * 描述: 当访问接口没有权限时，自定义的返回结果 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月9日 上午10:21:55
 */
@Slf4j
@Component
public class CustomAccessDenied implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
			throws IOException, ServletException {
		String ip = ServerUtil.getIp(request);
		log.info("IP：" + ip + "，请求接口'" + request.getRequestURI() + "'没有权限");
		BaseResult result = new BaseResult();
		result.setCode(ResultType.ERROR);
		result.setMessage("对不起，您没有权限访问");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().println(JSON.toJSONString(result));
		response.getWriter().flush();
	}

}
