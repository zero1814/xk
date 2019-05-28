package org.product.service.impl.activity;

import org.product.entity.activity.PcActivityStatus;
import org.product.repository.activity.PcActivityStatusRepository;
import org.product.service.activity.IPcActivityStatusService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcActivityStatusServiceImpl <br>
 * 描述: 活动状态业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:05:31
 */
@Service
public class PcActivityStatusServiceImpl extends BaseServiceImpl<PcActivityStatus, String, PcActivityStatusRepository>
		implements IPcActivityStatusService {

}
