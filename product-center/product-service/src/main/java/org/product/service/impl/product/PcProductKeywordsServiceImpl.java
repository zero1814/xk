package org.product.service.impl.product;

import org.product.entity.product.PcProductKeywords;
import org.product.repository.product.PcProductKeywordsRepository;
import org.product.service.product.IPcProductKeywordsService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcProductKeywordsServiceImpl <br>
 * 描述: 商品关键字业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:10
 */
@Service
public class PcProductKeywordsServiceImpl extends
		BaseServiceImpl<PcProductKeywords, String, PcProductKeywordsRepository> implements IPcProductKeywordsService {

}
