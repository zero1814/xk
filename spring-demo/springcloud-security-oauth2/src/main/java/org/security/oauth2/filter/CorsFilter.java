package org.security.oauth2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 
 * 类: CorsFilter <br>
 * 描述: 跨域过滤器 <br>
 * 作者: zhy<br>
 * 时间: 2019年5月13日 下午1:52:08
 */
@Component
public class CorsFilter implements Filter {
	final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		logger.info("*********************************进入product-cloud系统**************************");
		HttpServletResponse response = (HttpServletResponse) res;
		// 允许来自所有域名请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 设置所允许的HTTP请求方法
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		// 服务器支持的所有头信息字段，多个字段用逗号分隔
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, token");
		logger.info("*********************************product-cloud的过滤器被使用**************************");
		chain.doFilter(req, res);
	}

}