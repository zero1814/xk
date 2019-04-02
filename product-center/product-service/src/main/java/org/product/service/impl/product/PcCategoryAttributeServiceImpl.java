package org.product.service.impl.product;

import org.product.entity.category.PcCategoryAttribute;
import org.product.repository.product.PcCategoryAttributeRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.product.IPcCategoryAttributeService;
import org.springframework.stereotype.Service;

@Service
public class PcCategoryAttributeServiceImpl
		extends FlagEnabledServiceImpl<PcCategoryAttribute, String, PcCategoryAttributeRepository>
		implements IPcCategoryAttributeService {

}
