package org.product.service.impl.category;

import org.product.entity.category.PcCategoryAttribute;
import org.product.repository.category.PcCategoryAttributeRepository;
import org.product.service.category.IPcCategoryAttributeService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcCategoryAttributeServiceImpl <br>
 * 描述: 分类属性业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:02
 */
@Service
public class PcCategoryAttributeServiceImpl
		extends BaseServiceImpl<PcCategoryAttribute, String, PcCategoryAttributeRepository>
		implements IPcCategoryAttributeService {
}
