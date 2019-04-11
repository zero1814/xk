package org.system.service.impl.user;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.system.cache.prefix.UserInfo;
import org.system.entity.user.ScUserInfo;
import org.system.entity.user.ScUserStatus;
import org.system.repository.user.ScUserInfoRepository;
import org.system.repository.user.ScUserStatusRepository;
import org.system.result.user.ScUserPropertyResult;
import org.system.service.user.IScUserInfoService;
import org.zero.spring.jpa.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
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
	@Autowired
	private ScUserStatusRepository statusRepository;

	@Autowired
	private RedisTemplate<String, String> template;

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
		String password = entity.getPassword();
		String phone = entity.getPhone();
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(phone)) {
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
		return result;
	}

	/**
	 * 
	 * 方法: logout <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.system.service.user.IScUserInfoService#logout(java.lang.String)
	 */
	@Override
	public BaseResult logout(String userCode) {
		BaseResult result = new BaseResult();
		String key = UserInfo.User.toString() + userCode;
		Object obj = template.opsForHash().get(UserInfo.UserGroup.toString(), key);
		if (obj == null) {
			result.setCode(ResultType.NULL);
			result.setMessage("用户信息不存在");
			return result;
		}
		template.opsForHash().delete(UserInfo.UserGroup.toString(), key);
		result.setCode(ResultType.SUCCESS);
		result.setMessage("已登出");
		return result;
	}
}
