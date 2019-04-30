package org.product.service.impl.product;

import org.product.entity.product.PcProductType;
import org.product.repository.product.PcProductTypeRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.product.IPcProductTypeService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PcProductTypeServiceImpl <br>
 * 描述: 商品类型业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:44
 */
@Service
public class PcProductTypeServiceImpl extends FlagEnabledServiceImpl<PcProductType, String, PcProductTypeRepository>
		implements IPcProductTypeService {

}
