package org.product.service.impl.product;

import org.product.entity.product.PcSku;
import org.product.repository.product.PcSkuRepository;
import org.product.service.product.IPcSkuService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcSkuServiceImpl <br>
 * 描述: 商品sku业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:51
 */
@Service
public class PcSkuServiceImpl extends BaseServiceImpl<PcSku, String, PcSkuRepository> implements IPcSkuService {

}
