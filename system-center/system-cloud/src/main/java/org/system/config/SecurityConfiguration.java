package org.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.system.security.handler.CustomAccessDenied;
import org.system.security.handler.CustomAuthenticationEntryPoint;
import org.system.security.handler.CustomAuthenticationFailureHandler;
import org.system.security.handler.CustomAuthenticationSuccessHandler;
import org.system.security.handler.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * 
	 * 方法: configure <br>
	 * 
	 * @param http
	 * @throws Exception
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * http // 关闭csrf <br>
		 * .csrf().disable()<br>
		 * // .anonymous().disable()<br>
		 * //.cors().and().httpBasic()<br>
		 * .authorizeRequests()<br>
		 * // 任何用户都可以访问URL以"/resources/", equals "/signup", 或者 "/about"开头的URL。<br>
		 * .antMatchers("/resources/**","/login").permitAll()<br>
		 * //以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问。请注意我们使用 hasRole 方法<br>
		 * .antMatchers("/admin/**").hasRole("ADMIN")<br>
		 * // 任何以"/db/" 开头的URL需要用户同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"。.<br>
		 * .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")<br>
		 * // 尚未匹配的任何URL要求用户进行身份验证<br>
		 * .anyRequest().authenticated()<br>
		 * .and().formLogin()<br>
		 * .loginPage("/login")<br>
		 * // 登陆成功<br>
		 * .loginProcessingUrl("/login").defaultSuccessUrl("/index",true)<br>
		 * /** // 认证成功<br>
		 * .successHandler(new CustomAuthenticationSuccessHandler())<br>
		 * // 认证失败<br>
		 * .failureHandler(new CustomAuthenticationFailureHandler())<br>
		 * .and().exceptionHandling()<br>
		 * // 已经认证的用户访问自己没有权限的资源处理<br>
		 * .accessDeniedHandler(new GoAccessDeniedHandler())<br>
		 * // 未经过认证的永固访问受保护的资源<br>
		 * .authenticationEntryPoint(new GoAuthenticationEntryPoint())
		 **/
		/**
		 * .and().logout().permitAll()<br>
		 * // 注销功能<br>
		 * //.logoutUrl("/login")<br>
		 * // 注销之后跳转的URL。默认是/login?logout。具体查看 the JavaDoc文档.<br>
		 * // .logoutSuccessUrl("/login")<br>
		 * // 让你设置定制的 LogoutSuccessHandler。如果指定了这个选项那么logoutSuccessUrl()的设置会被忽略<br>
		 * // .logoutSuccessHandler()<br>
		 * // 指定是否在注销时让HttpSession无效。 默认设置为 true。<br>
		 * .invalidateHttpSession(true)<br>
		 * // 允许指定在注销成功时将移除的cookie。<br>
		 * .deleteCookies("\"JSESSIONID\"")<br>
		 * // cookie 失效时间,默认有效期为14天<br>
		 * .and().rememberMe()<br>
		 * .tokenValiditySeconds(1800)<br>
		 * .key("token_key");
		 */
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
			"/", 
			"/*.html",
			"/favicon.ico", 
			"/**/*.html",
			"/**/*.css", 
			"/**/*.js",
			"/swagger-resources/**",
			"/v2/api-docs/**")
			.permitAll()
			.antMatchers("/logout", "/login", "/register").permitAll()
			.antMatchers(HttpMethod.OPTIONS).permitAll()// 跨域请求会先进行一次options请求
			.anyRequest()// 除上面外的所有请求全部需要鉴权认证
			.authenticated()
			.and()
			.formLogin()
			.successHandler(successHandler())
			.failureHandler(failureHandler()).permitAll()
			.and()
			.logout()
			.logoutSuccessHandler(logoutSuccessHandler());
		// 禁用缓存
		http.headers().cacheControl();
		//记住我
		http.rememberMe().rememberMeParameter("remember-me").userDetailsService(userDetailsService).tokenValiditySeconds(300);
		// 添加自定义未授权和未登录结果返回
		http.exceptionHandling().accessDeniedHandler(customAccessDenied())
				.authenticationEntryPoint(customAuthenticationEntryPoint());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	/**
	 * 
	 * 方法: passwordEncoder <br>
	 * 描述: 装载BCrypt密码编码器 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午2:22:21
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * 
	 * 方法: customAuthenticationEntryPoint <br>
	 * 描述: 当未登录或者token失效访问接口时，自定义的返回结果 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午2:31:36
	 * 
	 * @return
	 */
	@Bean
	public CustomAuthenticationEntryPoint customAuthenticationEntryPoint() {
		return new CustomAuthenticationEntryPoint();
	}

	/**
	 * 
	 * 方法: customAccessDenied <br>
	 * 描述: 当访问接口没有权限时，自定义的返回结果 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午2:32:27
	 * 
	 * @return
	 */
	@Bean
	public CustomAccessDenied customAccessDenied() {
		return new CustomAccessDenied();
	}

	/**
	 * 方法: successHandler <br>
	 * 描述: 成功的身份验证实现执行是处理导航到后续的目标 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午2:38:33
	 * 
	 * @return
	 */
	@Bean
	public CustomAuthenticationSuccessHandler successHandler() {
		return new CustomAuthenticationSuccessHandler();
	}

	/**
	 * 
	 * 方法: failureHandler <br>
	 * 描述: 如果身份验证失败时调用 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年4月24日 下午2:39:21
	 * 
	 * @return
	 */
	@Bean
	public CustomAuthenticationFailureHandler failureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
	
	public CustomLogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}
}
