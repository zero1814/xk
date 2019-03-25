package org.product.service.impl.store;

import org.product.entity.store.PcStoreStatus;
import org.product.repository.store.PcStoreStatusRepository;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcStoreStatusService extends BaseServiceImpl<PcStoreStatus, String, PcStoreStatusRepository> {

}
