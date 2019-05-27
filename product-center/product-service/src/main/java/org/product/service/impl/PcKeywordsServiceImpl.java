package org.product.service.impl;

import org.product.entity.PcKeyword;
import org.product.repository.PcKeywordsRepository;
import org.product.service.IPcKeywordsService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcKeywordsServiceImpl <br>
 * 描述: 常用关键字业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:52
 */
@Service
public class PcKeywordsServiceImpl extends BaseServiceImpl<PcKeyword, String, PcKeywordsRepository>
		implements IPcKeywordsService {

}
