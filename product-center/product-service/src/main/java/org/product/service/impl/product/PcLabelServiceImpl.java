package org.product.service.impl.product;

import org.product.entity.product.PcLabel;
import org.product.repository.product.PcLabelRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.product.IPcLabelService;
import org.springframework.stereotype.Service;

@Service
public class PcLabelServiceImpl extends FlagEnabledServiceImpl<PcLabel, String, PcLabelRepository> implements IPcLabelService {

}
