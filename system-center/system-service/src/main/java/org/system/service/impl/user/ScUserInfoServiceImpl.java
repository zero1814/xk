package org.system.service.impl.user;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.system.entity.user.ScUserInfo;
import org.system.entity.user.ScUserStatus;
import org.system.repository.user.ScUserInfoRepository;
import org.system.repository.user.ScUserStatusRepository;
import org.system.result.user.ScUserPropertyResult;
import org.system.service.user.IScUserInfoService;
import org.zero.spring.jpa.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.MD5Util;
import zero.commons.basics.helper.CodeHelper;
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
	@Autowired
	private ScUserStatusRepository statusRepository;

	@Override
	public EntityResult<ScUserInfo> insert(ScUserInfo entity) {
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
		return super.insert(entity);
	}

	@Override
	public ScUserPropertyResult initProperty() {
		ScUserPropertyResult result = new ScUserPropertyResult();
		try {
			List<ScUserStatus> statusList = statusRepository.findAll();
			result.setStatusList(statusList);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("加载成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("用户初始化参数加载失败");
		}
		return result;
	}

	@Override
	public EntityResult<ScUserInfo> login(ScUserInfo entity) {
		EntityResult<ScUserInfo> result = new EntityResult<ScUserInfo>();
		String userName = entity.getUserName();
		String password = MD5Util.md5Hex(entity.getPassword());
		String phone = entity.getPhone();
		if (StringUtils.isBlank(userName) && StringUtils.isBlank(phone)) {
			result.setCode(ResultType.NULL);
			result.setMessage("用户名/手机号 不能为空");
			return result;
		}

		if (StringUtils.isBlank(password)) {
			result.setCode(ResultType.NULL);
			result.setMessage("密码 不能为空");
			return result;
		}
		result = select(entity);
		if (result.getCode() == ResultType.SUCCESS) {
			String token = CodeHelper.getUUID();
			/**
			 * 设置30分钟后过期
			 */
			template.opsForValue().set(token, result.getEntity(), 30, TimeUnit.MINUTES);
		}
		return result;
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
