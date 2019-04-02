package org.product.service.impl.label;

import org.product.entity.label.PcLabelType;
import org.product.repository.label.PcLabelTypeRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.label.IPcLabelTypeService;
import org.springframework.stereotype.Service;

@Service
public class PcLabelTypeServiceImpl extends FlagEnabledServiceImpl<PcLabelType, String, PcLabelTypeRepository>
		implements IPcLabelTypeService {

}
