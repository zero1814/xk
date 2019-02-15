package org.product.service.impl.product;

import org.product.entity.product.PcProductPic;
import org.product.repository.product.PcProductPicRepository;
import org.product.service.product.IPcProductPicService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductPicServiceImpl extends BaseServiceImpl<PcProductPic, String, PcProductPicRepository>
		implements IPcProductPicService {

}
