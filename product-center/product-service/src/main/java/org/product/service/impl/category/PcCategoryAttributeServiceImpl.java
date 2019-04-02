package org.product.service.impl.category;

import org.product.entity.category.PcCategoryAttribute;
import org.product.repository.category.PcCategoryAttributeRepository;
import org.product.service.category.IPcCategoryAttributeService;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PcCategoryAttributeServiceImpl
		extends FlagEnabledServiceImpl<PcCategoryAttribute, String, PcCategoryAttributeRepository>
		implements IPcCategoryAttributeService {

}
