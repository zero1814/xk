package org.system.service.impl.user;

import org.springframework.stereotype.Service;
import org.system.entity.user.ScUserStatus;
import org.system.repository.user.ScUserStatusRepository;
import org.system.service.impl.FlagEnabledServiceImpl;
import org.system.service.user.IScUserStatusService;

/**
 * 
 * 类: ScUserStatusServiceImpl <br>
 * 描述: 系统用户状态表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:05:23
 */
@Service
public class ScUserStatusServiceImpl extends FlagEnabledServiceImpl<ScUserStatus, String, ScUserStatusRepository>
		implements IScUserStatusService {

}
