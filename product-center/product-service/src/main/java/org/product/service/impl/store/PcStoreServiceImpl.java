package org.product.service.impl.store;

import org.product.entity.store.PcStore;
import org.product.repository.store.PcStoreRepository;
import org.product.service.store.IPcStoreService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcStoreServiceImpl extends BaseServiceImpl<PcStore, String, PcStoreRepository> implements IPcStoreService {

}
