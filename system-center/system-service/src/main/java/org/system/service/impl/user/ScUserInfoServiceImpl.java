package org.system.service.impl.user;

import org.springframework.stereotype.Service;
import org.system.entity.user.ScUserInfo;
import org.system.repository.user.ScUserInfoRepository;
import org.system.service.user.IScUserInfoService;
import org.zero.spring.jpa.BaseServiceImpl;

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

}
