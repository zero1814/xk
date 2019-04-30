package org.product.service.impl.product;

import org.product.entity.product.PcSkuStatus;
import org.product.repository.product.PcSkuStatusRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.product.IPcSkuStatusService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PcSkuStatusServiceImpl <br>
 * 描述: 商品sku业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:00
 */
@Service
public class PcSkuStatusServiceImpl extends FlagEnabledServiceImpl<PcSkuStatus, String, PcSkuStatusRepository>
		implements IPcSkuStatusService {

}
