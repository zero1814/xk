package org.product.service.impl.product;

import org.product.entity.product.PcBrand;
import org.product.repository.product.PcBrandRepository;
import org.springframework.stereotype.Service;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.product.IPcBrandService;

@Service
public class PcBrandServiceImpl extends FlagEnabledServiceImpl<PcBrand, String, PcBrandRepository> implements IPcBrandService {

}
