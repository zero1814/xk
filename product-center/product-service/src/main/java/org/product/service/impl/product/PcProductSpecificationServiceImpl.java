package org.product.service.impl.product;

import org.product.entity.product.PcProductSpecification;
import org.product.repository.product.PcProductSpecificationRepository;
import org.product.service.product.IPcProductSpecificationService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductSpecificationServiceImpl
		extends BaseServiceImpl<PcProductSpecification, String, PcProductSpecificationRepository>
		implements IPcProductSpecificationService {

}
