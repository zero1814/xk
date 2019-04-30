package org.product.service.impl.product;

import org.product.entity.product.PcProductStatus;
import org.product.repository.product.PcProductStatusRepository;
import org.springframework.stereotype.Service;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.product.IPcProductStatusService;

/**
 * 
 * 类: PcProductStatusServiceImpl <br>
 * 描述: 商品状态业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:36
 */
@Service
public class PcProductStatusServiceImpl extends FlagEnabledServiceImpl<PcProductStatus, String, PcProductStatusRepository>
		implements IPcProductStatusService {

}
