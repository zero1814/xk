package org.authorization.cloud.service.impl;

import java.util.concurrent.TimeUnit;

import org.authorization.cloud.entity.ScUser;
import org.authorization.cloud.repository.ScUserRepository;
import org.authorization.cloud.service.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import com.alibaba.fastjson.JSON;

@Service
public class ScUserServiceImpl extends BaseServiceImpl<ScUser, String, ScUserRepository> implements IScUserService {

	@Autowired
	private ScUserRepository repository;
	@Autowired
	private RedisTemplate<String, String> template;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			ScUser user = null;
			if (template.hasKey(username)) {
				String json = template.opsForValue().get(username);
				user = JSON.toJavaObject(JSON.parseObject(json), ScUser.class);
			} else {
				user = repository.findByUsername(username);
				if (user == null) {
					return null;
				}
				// 缓存保存30分钟
				template.opsForValue().set(username, JSON.toJSONString(user), 30, TimeUnit.MINUTES);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
