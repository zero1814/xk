package org.product.service.impl.label;

import org.product.entity.label.PcLabel;
import org.product.repository.label.PcLabelRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.label.IPcLabelService;
import org.springframework.stereotype.Service;

@Service
public class PcLabelServiceImpl extends FlagEnabledServiceImpl<PcLabel, String, PcLabelRepository>
		implements IPcLabelService {

}
