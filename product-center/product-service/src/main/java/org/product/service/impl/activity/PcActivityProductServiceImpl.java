package org.product.service.impl.activity;

import org.product.entity.activity.PcActivityProduct;
import org.product.repository.activity.PcActivityProductRepository;
import org.product.service.activity.IPcActivityProductService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcActivityProductServiceImpl <br>
 * 描述: 活动商品业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:05:09
 */
@Service
public class PcActivityProductServiceImpl extends
		BaseServiceImpl<PcActivityProduct, String, PcActivityProductRepository> implements IPcActivityProductService {

}
