package org.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.system.security.handler.LogOutSuccess;
import org.system.security.handler.LoginFailure;
import org.system.security.handler.LoginSuccess;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * 登录页
	 */
	@Value("${security.login.page}")
	private String loginPage;

	/**
	 * 登录验证接口
	 */
	@Value("${security.login.process}")
	private String loginProcess;
	
	/**
	 * 登出验证接口
	 */
	@Value("${security.logout.url}")
	private String logout;
	/**
	 * 不需要权限认证的url数组
	 */
	@Value("${security.auth.ant_patterns}")
	private String antPatterns;

	/**
	 * 用户成功登陆处理类
	 */
	@Autowired
	private LoginSuccess sucessHandler;

	/**
	 * 用户失败登陆处理类
	 */
	@Autowired
	private LoginFailure failureHander;
	

	/**
	 * 用户登出处理类
	 */
	@Autowired
	private LogOutSuccess logOutSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 表单登录
		http.formLogin()
				// 登录页面
//				.loginPage(loginPage)
				// 登录需要经过的url请求
				.loginProcessingUrl(loginProcess)
				.successHandler(sucessHandler)
				.failureHandler(failureHander)
				.and()
				.authorizeRequests()
				// 不需要权限认证的url
				.antMatchers(antPatterns).permitAll()
				// 任何请求
				.anyRequest()
				// 需要身份认证
				.authenticated()
				.and()
				.logout()
				.logoutSuccessUrl(logout)
				.logoutSuccessHandler(logOutSuccessHandler)
				// 关闭跨站请求防护
				.and()
				.csrf()
				.disable();
	}

}
