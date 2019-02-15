package org.product.service.impl.product;

import org.product.entity.product.PcBrandInfo;
import org.product.repository.product.PcBrandInfoRepository;
import org.zero.spring.jpa.BaseServiceImpl;
import org.product.service.product.IPcBrandInfoService;
import org.springframework.stereotype.Service;

@Service
public class PcBrandInfoServiceImpl extends BaseServiceImpl<PcBrandInfo, String, PcBrandInfoRepository>
		implements IPcBrandInfoService {

}
