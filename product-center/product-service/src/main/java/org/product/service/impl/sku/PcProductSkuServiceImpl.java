package org.product.service.impl.sku;

import org.product.entity.sku.PcSku;
import org.product.repository.sku.PcSkuRepository;
import org.product.service.sku.IPcProductSkuService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductSkuServiceImpl extends BaseServiceImpl<PcSku, String, PcSkuRepository>
		implements IPcProductSkuService {

}
