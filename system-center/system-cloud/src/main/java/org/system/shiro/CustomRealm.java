package org.system.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(CustomRealm.class);

	/**
	 * 
	 * 方法: doGetAuthorizationInfo <br>
	 * 描述: 角色权限和对应权限添加
	 * 
	 * @param principals
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("开始进行用户的权限校验");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String userName = (String) principals.getPrimaryPrincipal();
		if (StringUtils.isNotBlank(userName)) {
		}
		return authorizationInfo;
	}

	/**
	 * 
	 * 方法: doGetAuthenticationInfo <br>
	 * 描述: 用户认证
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("-------------------->");
		logger.info("---------------------->用户登录验证开始");
		// 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		UsernamePasswordToken user = (UsernamePasswordToken) token;
		String userName = user.getUsername();
		String password = String.valueOf(user.getPassword());
		logger.info("用户名：" + userName + ",密码：" + password);
		logger.info("---------------------->用户登录验证结束");
		// 密码可以通过SimpleHash加密，然后保存进数据库。
		// 此处是获取数据库内的账号、密码、盐值，保存到登陆信息info中
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, password, getName());
		return authenticationInfo;
	}

}
