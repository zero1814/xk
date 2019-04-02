package org.product.service.impl.product;

import org.product.entity.category.PcCategory;
import org.product.repository.product.PcCategoryRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.product.IPcCategoryService;
import org.springframework.stereotype.Service;

@Service
public class PcCategoryServiceImpl extends FlagEnabledServiceImpl<PcCategory, String, PcCategoryRepository>
		implements IPcCategoryService {

}
