package org.zuul.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class TokenFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		return null;
	}

	/**
	 * 
	 * 方法: shouldFilter <br>
	 * 描述: 控制过滤器生效不生效，可以在里面写一串逻辑来控制
	 * 
	 * @return
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 
	 * 方法: filterOrder <br>
	 * 描述: 自定义过滤器执行的顺序，数值越大越靠后执行，越小就越先执行
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
	 * 描述: 四种类型：pre,routing,error,post<br>
	 * pre：主要用在路由映射的阶段是寻找路由映射表的<br>
	 * routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用<br>
	 * error:一旦前面的过滤器出错了，会调用error过滤器。<br>
	 * post:当routing，error运行完后才会调用该过滤器，是在最后阶段的<br>
	 * 
	 * @return
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
