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
import org.system.security.handler.RestAccessDenied;
import org.system.security.handler.RestAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAccessDenied accessDenied;
	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
	        .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
	                "/",
	                "/*.html",
	                "/favicon.ico",
	                "/**/*.html",
	                "/**/*.css",
	                "/**/*.js",
	                "/swagger-resources/**",
	                "/v2/api-docs/**"
	        ).permitAll()
	        .antMatchers("/logout","/login","/register").permitAll()
	        .antMatchers(HttpMethod.OPTIONS).permitAll()//跨域请求会先进行一次options请求
            .anyRequest()// 除上面外的所有请求全部需要鉴权认证
			.authenticated();
		// 禁用缓存
		http.headers().cacheControl();
		// 添加自定义未授权和未登录结果返回
		http.exceptionHandling().accessDeniedHandler(accessDenied).authenticationEntryPoint(authenticationEntryPoint);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
