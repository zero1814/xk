package org.product.service.impl.product;

import org.product.entity.sku.PcSku;
import org.product.repository.product.PcProductSkuRepository;
import org.product.service.product.IPcProductSkuService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductSkuServiceImpl extends BaseServiceImpl<PcSku, String, PcProductSkuRepository>
		implements IPcProductSkuService {

}
