package org.product.service.impl.product;

import org.product.entity.product.PcProductInfo;
import org.product.repository.product.PcProductInfoRepository;
import org.product.service.product.IPcProductInfoService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductInfoServiceImpl extends BaseServiceImpl<PcProductInfo, String, PcProductInfoRepository>
		implements IPcProductInfoService {

}
