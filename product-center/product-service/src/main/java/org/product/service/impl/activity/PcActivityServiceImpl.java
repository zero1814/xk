package org.product.service.impl.activity;

import org.product.entity.activity.PcActivity;
import org.product.repository.activity.PcActivityRepository;
import org.product.service.activity.IPcActivityService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcActivityServiceImpl <br>
 * 描述: 活动业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:49:53
 */
@Service
public class PcActivityServiceImpl extends BaseServiceImpl<PcActivity, String, PcActivityRepository>
		implements IPcActivityService {

}
