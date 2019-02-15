package org.product.service.impl.product;

import org.product.entity.product.PcProductStock;
import org.product.repository.product.PcProductStockRepository;
import org.product.service.product.IPcProductStockService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductStockServiceImpl extends BaseServiceImpl<PcProductStock, String, PcProductStockRepository>
		implements IPcProductStockService {

}
