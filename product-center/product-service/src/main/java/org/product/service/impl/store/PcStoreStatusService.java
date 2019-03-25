package org.product.service.impl.store;

import org.product.entity.store.PcStoreStatus;
import org.product.repository.store.PcStoreStatusRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.stereotype.Service;

@Service
public class PcStoreStatusService extends FlagEnabledServiceImpl<PcStoreStatus, String, PcStoreStatusRepository>
		implements IPcStoreStatusService {

}
