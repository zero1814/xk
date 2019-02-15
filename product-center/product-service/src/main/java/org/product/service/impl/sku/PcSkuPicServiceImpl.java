package org.product.service.impl.sku;

import org.product.entity.sku.PcSkuPic;
import org.product.repository.sku.PcSkuPicRepository;
import org.product.service.sku.IPcSkuPicService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcSkuPicServiceImpl extends BaseServiceImpl<PcSkuPic, String, PcSkuPicRepository>
		implements IPcSkuPicService {

}
