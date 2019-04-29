package org.product.service.impl.product;

import org.product.entity.product.PcProduct;
import org.product.repository.product.PcProductRepository;
import org.product.service.product.IPcProductService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcProductServiceImpl <br>
 * 描述: 商品业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:18
 */
@Service
public class PcProductServiceImpl extends BaseServiceImpl<PcProduct, String, PcProductRepository>
		implements IPcProductService {

}
