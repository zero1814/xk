package org.system.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.system.entity.role.ScPermission;
import org.system.entity.role.ScRole;
import org.system.entity.user.ScUserInfo;
import org.system.service.user.IScUserInfoService;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private IScUserInfoService service;

	/**
	 * 
	 * 方法: loadUserByUsername <br>
	 * 描述: 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
	 * 
	 * @param userName
	 * @return
	 * @throws UsernameNotFoundException
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("根据username='" + username + "'获取用户信息--------->");
		ScUserInfo param = new ScUserInfo();
		param.setUserName(username);
		EntityResult<ScUserInfo> result = service.select(param);
		log.info("查询结果：\n" + JSON.toJSONString(result));
		if (result.getCode() == ResultType.SUCCESS) {
			ScUserInfo entity = result.getEntity();
			List<ScRole> roles = entity.getRoles();
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			if (roles != null && roles.size() > 0) {
				for (ScRole role : roles) {
					List<ScPermission> permissions = role.getPermissions();
					if (permissions != null && permissions.size() > 0) {
						for (ScPermission permission : permissions) {
							authorities.add(new SimpleGrantedAuthority(permission.getCode()));
						}
					}
				}
			}
			return new User(entity.getUserName(), entity.getPassword(), authorities);
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

}
