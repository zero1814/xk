package org.product.service.impl.product;

import org.product.entity.product.PcProductStatus;
import org.product.repository.product.PcProductStatusRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PcProductStatusServiceImpl
		extends FlagEnabledServiceImpl<PcProductStatus, String, PcProductStatusRepository> {

}
