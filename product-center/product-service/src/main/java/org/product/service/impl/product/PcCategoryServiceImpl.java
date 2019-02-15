package org.product.service.impl.product;

import org.product.entity.product.PcCategory;
import org.product.repository.product.PcCategoryRepository;
import org.product.service.product.IPcCategoryService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcCategoryServiceImpl extends BaseServiceImpl<PcCategory, String, PcCategoryRepository>
		implements IPcCategoryService {

}
