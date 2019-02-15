package org.product.service.impl.store;

import org.product.entity.store.PcStoreType;
import org.product.repository.store.PcStoreTypeRepository;
import org.product.service.store.IPcStoreTypeService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcStoreTypeServiceImpl extends BaseServiceImpl<PcStoreType, String, PcStoreTypeRepository>
		implements IPcStoreTypeService {

}
