package org.product.service.impl.sku;

import org.product.entity.sku.PcSkuType;
import org.product.repository.sku.PcSkuTypeRepository;
import org.product.service.sku.IPcSkuTypeService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcSkuTypeServiceImpl extends BaseServiceImpl<PcSkuType, String, PcSkuTypeRepository>
		implements IPcSkuTypeService {

}
