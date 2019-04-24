package org.system.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.system.jwt.JwtTokenUtil;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: CustomAuthenticationSuccessHandler <br>
 * 描述: 用于处理一个成功的身份验证实现执行是处理导航到后续的目标 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月24日 下午2:36:23
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	// 有效期
	@Value("${jwt.expiration}")
	private Long expiration;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String jwtToken = jwtTokenUtil.generateToken(userDetails);
		jwtTokenUtil.setExpire(jwtToken, userDetails.getUsername(), expiration + 100000);
		BaseResult result = new BaseResult();
		result.setCode(ResultType.SUCCESS);
		result.setMessage("登录成功");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().println(JSON.toJSONString(result));
		response.getWriter().flush();
	}

}
