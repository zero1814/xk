package org.system.service.impl.user;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.system.dto.LoginParam;
import org.system.entity.user.ScUserInfo;
import org.system.repository.user.ScUserInfoRepository;
import org.system.service.user.IScUserInfoService;
import org.zero.spring.jpa.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.MD5Util;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: ScUserInfoServiceImpl <br>
 * 描述: 系统用户表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:03:44
 */
@Slf4j
@Service
public class ScUserInfoServiceImpl extends BaseServiceImpl<ScUserInfo, String, ScUserInfoRepository>
		implements IScUserInfoService {

	@Resource
	private RedisTemplate<String, Object> template;
	@Autowired
	private ScUserInfoRepository repository;

	@Override
	public EntityResult<ScUserInfo> create(ScUserInfo entity) {
		EntityResult<ScUserInfo> result = new EntityResult<ScUserInfo>();
		try {
			entity.setPassword(MD5Util.md5Hex(entity.getPassword()));
			ExampleMatcher matcher = ExampleMatcher.matching();
			matcher.withMatcher("userName", GenericPropertyMatchers.exact())
					.withMatcher("phone", GenericPropertyMatchers.exact())
					.withMatcher("eMail", GenericPropertyMatchers.exact()).withIgnorePaths("id", "password");
			Example<ScUserInfo> example = Example.of(entity, matcher);
			boolean flag = repository.exists(example);
			if (flag) {
				result.setCode(ResultType.ERROR);
				result.setMessage("对象已存在");
			}
		} catch (Exception e) {
			log.error("添加用户报错，错误原因：" + e.getMessage());
		}
		return super.create(entity);
	}

	@Override
	public EntityResult<ScUserInfo> login(LoginParam param) {
		EntityResult<ScUserInfo> result = new EntityResult<ScUserInfo>();
		String userName = param.getUsername();
		String password = MD5Util.md5Hex(param.getPassword());
		if (StringUtils.isBlank(userName)) {
			result.setCode(ResultType.NULL);
			result.setMessage("用户名不能为空");
			return result;
		}

		if (StringUtils.isBlank(password)) {
			result.setCode(ResultType.NULL);
			result.setMessage("密码 不能为空");
			return result;
		}
		ScUserInfo entity = new ScUserInfo();
		entity.setUserName(userName);
		entity.setPassword(password);
		return select(entity);
	}

	/**
	 * 
	 * 方法: logout <br>
	 * 
	 * @param token
	 * @return
	 * @see org.system.service.user.IScUserInfoService#logout(java.lang.String)
	 */
	@Override
	public BaseResult logout(String token) {
		BaseResult result = new BaseResult();
		Object obj = template.opsForValue().get(token);
		if (obj == null) {
			result.setCode(ResultType.NULL);
			result.setMessage("用户信息不存在");
			return result;
		}
		template.delete(token);
		result.setCode(ResultType.SUCCESS);
		result.setMessage("已登出");
		return result;
	}

	/**
	 * 
	 * 方法: get <br>
	 * 
	 * @param token
	 * @return
	 * @see org.system.service.user.IScUserInfoService#get(java.lang.String)
	 */
	@Override
	public EntityResult<ScUserInfo> get(String token) {
		EntityResult<ScUserInfo> result = new EntityResult<ScUserInfo>();
		try {
			Object obj = template.opsForValue().get(token);
			if (obj == null) {
				result.setCode(ResultType.ERROR);
				result.setMessage("用户未登录或已注销");
				return result;
			}
			ScUserInfo user = (ScUserInfo) obj;
			result.setEntity(user);
			result.setCode(ResultType.SUCCESS);
		} catch (Exception e) {
			log.error("获取用户信息报错，请联系管理员");
		}
		return null;
	}
}
