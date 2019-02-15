package org.product.service.impl.sku;

import org.product.entity.sku.PcSkuInfo;
import org.product.repository.sku.PcSkuInfoRepository;
import org.product.service.sku.IPcSkuInfoService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcSkuInfoServiceImpl extends BaseServiceImpl<PcSkuInfo, String, PcSkuInfoRepository>
		implements IPcSkuInfoService {

}
