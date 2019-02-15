package org.product.service.impl.sku;

import org.product.entity.sku.PcSkuStatus;
import org.product.repository.sku.PcSkuStatusRepository;
import org.product.service.sku.IPcSkuStatusService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcSkuStatusServiceImpl extends BaseServiceImpl<PcSkuStatus, String, PcSkuStatusRepository>
		implements IPcSkuStatusService {

}
