package org.product.service.impl.store;

import org.product.entity.store.PcStoreStatus;
import org.product.repository.store.PcStoreStatusRepository;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcStoreStatusServiceImpl extends BaseServiceImpl<PcStoreStatus, String, PcStoreStatusRepository>
		implements IPcStoreStatusService {

}
