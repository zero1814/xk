package org.product.service.impl.product;

import org.product.entity.product.PcProduct;
import org.product.repository.product.PcProductRepository;
import org.product.service.product.IPcProductService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductServiceImpl extends BaseServiceImpl<PcProduct, String, PcProductRepository>
		implements IPcProductService {

}
