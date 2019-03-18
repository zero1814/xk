package org.system.service.impl.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.user.ScUserInfo;
import org.system.entity.user.ScUserStatus;
import org.system.entity.user.ScUserType;
import org.system.repository.user.ScUserInfoRepository;
import org.system.repository.user.ScUserStatusRepository;
import org.system.repository.user.ScUserTypeRepository;
import org.system.result.user.ScUserPropertyResult;
import org.system.service.user.IScUserInfoService;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: ScUserInfoServiceImpl <br>
 * 描述: 系统用户表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:03:44
 */
@Service
public class ScUserInfoServiceImpl extends BaseServiceImpl<ScUserInfo, String, ScUserInfoRepository>
		implements IScUserInfoService {
	private static final Logger logger = LoggerFactory.getLogger(ScUserInfoServiceImpl.class);
	@Autowired
	private ScUserTypeRepository typeRepository;
	@Autowired
	private ScUserStatusRepository statusRepository;

	@Override
	public ScUserPropertyResult initProperty() {
		ScUserPropertyResult result = new ScUserPropertyResult();
		try {
			List<ScUserType> typeList = typeRepository.findAll();
			List<ScUserStatus> statusList = statusRepository.findAll();
			result.setTypeList(typeList);
			result.setStatusList(statusList);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("加载成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("用户初始化参数加载失败");
		}
		return result;
	}

}
