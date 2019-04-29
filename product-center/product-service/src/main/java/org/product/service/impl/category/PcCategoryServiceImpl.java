package org.product.service.impl.category;

import org.product.entity.category.PcCategory;
import org.product.repository.category.PcCategoryRepository;
import org.product.service.category.IPcCategoryService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;
/**
 * 
 * 类: PcCategoryServiceImpl <br>
 * 描述: 分类业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:09
 */
@Service
public class PcCategoryServiceImpl extends BaseServiceImpl<PcCategory, String, PcCategoryRepository>
		implements IPcCategoryService {

}
