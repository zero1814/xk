package org.system.service.impl.role;

import org.springframework.stereotype.Service;
import org.system.entity.role.ScSystemInfo;
import org.system.repository.role.ScSystemInfoRepository;
import org.system.service.impl.FlagEnabledServiceImpl;
import org.system.service.role.IScSystemInfoService;

/**
 * 
 * 类: ScSystemInfoServiceImpl <br>
 * 描述: 系统中心业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月19日 下午3:50:13
 */
@Service
public class ScSystemInfoServiceImpl extends FlagEnabledServiceImpl<ScSystemInfo, String, ScSystemInfoRepository>
		implements IScSystemInfoService {

}
