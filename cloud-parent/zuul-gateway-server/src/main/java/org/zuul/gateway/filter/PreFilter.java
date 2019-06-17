package org.zuul.gateway.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 类: PreFilter <br>
 * 描述: 前置（Pre）<br>
 * 限流<br>
 * 鉴权<br>
 * 参数校验调整 <br>
 * 作者: zhy<br>
 * 时间: 2019年6月13日 上午11:36:42
 */
@Slf4j
public class PreFilter extends ZuulFilter {

	/**
	 * 
	 * 方法: run <br>
	 * 描述: filter需要执行的具体操作
	 * 
	 * @return
	 * @throws ZuulException
	 * @see com.netflix.zuul.IZuulFilter#run()
	 */
	@Override
	public Object run() throws ZuulException {
		log.debug("*****************FirstFilter run start*****************");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletResponse response = ctx.getResponse();
		HttpServletRequest request = ctx.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", "authorization, content-type");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET");
		response.setHeader("Access-Control-Expose-Headers", "X-forwared-port, X-forwarded-host");
		response.setHeader("Vary", "Origin,Access-Control-Request-Method,Access-Control-Request-Headers"); // 不再路由
		ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(200);
		log.debug("*****************FirstFilter run end*****************");
		return null;
	}

	/**
	 * 
	 * 方法: shouldFilter <br>
	 * 描述: 表示是否需要执行该filter，true表示执行，false表示不执行
	 * 
	 * @return
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest(); // 只过滤OPTIONS 请求
		if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 方法: filterOrder <br>
	 * 描述: 定义filter的顺序，数字越小表示顺序越高，越先执行
	 * 
	 * @return
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 
	 * 方法: filterType <br>
	 * 描述: 定义filter的类型，有pre、route、post、error四种
	 * 
	 * @return
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}
