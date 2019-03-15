package org.system.service.impl.user;

import org.springframework.stereotype.Service;
import org.system.entity.user.ScUserType;
import org.system.repository.user.ScUserTypeRepository;
import org.system.service.impl.FlagEnabledServiceImpl;
import org.system.service.user.IScUserTypeService;

/**
 * 
 * 类: ScUserTypeServiceImpl <br>
 * 描述: 系统用户类型表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:07:02
 */
@Service
public class ScUserTypeServiceImpl extends FlagEnabledServiceImpl<ScUserType, String, ScUserTypeRepository>
		implements IScUserTypeService {

}
