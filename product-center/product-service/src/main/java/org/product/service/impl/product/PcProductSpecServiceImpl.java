package org.product.service.impl.product;

import org.product.entity.product.PcProductSpec;
import org.product.repository.product.PcProductSpecRepository;
import org.product.service.product.IPcProductSpecService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcProductSpecServiceImpl <br>
 * 描述: 商品规格业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:25
 */
@Service
public class PcProductSpecServiceImpl extends BaseServiceImpl<PcProductSpec, String, PcProductSpecRepository>
		implements IPcProductSpecService {

}
