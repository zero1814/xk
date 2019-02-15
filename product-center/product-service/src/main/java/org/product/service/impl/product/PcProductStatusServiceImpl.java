package org.product.service.impl.product;

import org.product.entity.product.PcProductStatus;
import org.product.repository.product.PcProductStatusRepository;
import org.product.service.product.IPcProductStatusService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductStatusServiceImpl extends BaseServiceImpl<PcProductStatus, String, PcProductStatusRepository>
		implements IPcProductStatusService {

}
