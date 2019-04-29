package org.system.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: CustomAuthenticationFailureHandler <br>
 * 描述: 如果身份验证失败时调用 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月24日 下午2:35:13
 */
@Slf4j
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.error("身份验证失败:\n" + exception.getMessage());
		BaseResult result = new BaseResult();
		result.setCode(ResultType.ERROR);
		result.setMessage("登录失败，请重试");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().println(JSON.toJSONString(result));
		response.getWriter().flush();
	}

}
