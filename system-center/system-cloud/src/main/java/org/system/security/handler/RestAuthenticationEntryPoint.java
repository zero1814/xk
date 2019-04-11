package org.system.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: RestAuthenticationEntryPoint <br>
 * 描述: 当未登录或者token失效访问接口时，自定义的返回结果 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月9日 上午10:24:39
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		BaseResult result = new BaseResult();
		result.setCode(ResultType.ERROR);
		result.setMessage("对不起，您尚未登录，请登录后重试");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().println(result);
		response.getWriter().flush();
	}

}
