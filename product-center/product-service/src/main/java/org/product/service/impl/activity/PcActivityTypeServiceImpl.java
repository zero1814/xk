package org.product.service.impl.activity;

import org.product.entity.activity.PcActivityType;
import org.product.repository.activity.PcActivityTypeRepository;
import org.product.service.activity.IPcActivityTypeService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcActivityTypeServiceImpl <br>
 * 描述: 活动类型业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:05:40
 */
@Service
public class PcActivityTypeServiceImpl extends BaseServiceImpl<PcActivityType, String, PcActivityTypeRepository>
		implements IPcActivityTypeService {

}
