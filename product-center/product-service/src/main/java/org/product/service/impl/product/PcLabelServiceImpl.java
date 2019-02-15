package org.product.service.impl.product;

import org.product.entity.product.PcLabel;
import org.product.repository.product.PcLabelRepository;
import org.product.service.product.IPcLabelService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcLabelServiceImpl extends BaseServiceImpl<PcLabel, String, PcLabelRepository> implements IPcLabelService {

}
