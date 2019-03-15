package org.system.service.impl.role;

import org.springframework.stereotype.Service;
import org.system.entity.role.ScApiInfo;
import org.system.repository.role.ScApiInfoRepository;
import org.system.service.role.IScApiInfoService;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: ScApiInfoServiceImpl <br>
 * 描述: 系统接口说明表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午1:59:11
 */
@Service
public class ScApiInfoServiceImpl extends BaseServiceImpl<ScApiInfo, String, ScApiInfoRepository>
		implements IScApiInfoService {

}
