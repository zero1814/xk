package org.product.service.impl.product;

import org.product.entity.product.PcProductType;
import org.product.repository.product.PcProductTypeRepository;
import org.product.service.product.IPcProductTypeService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductTypeServiceImpl extends BaseServiceImpl<PcProductType, String, PcProductTypeRepository>
		implements IPcProductTypeService {

}
