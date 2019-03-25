package org.product.service.impl.store;

import org.product.entity.store.PcStoreLevel;
import org.product.repository.store.PcStoreLevelRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.store.IPcStoreLevelService;
import org.springframework.stereotype.Service;

@Service
public class PcStoreLevelServiceImpl extends FlagEnabledServiceImpl<PcStoreLevel, String, PcStoreLevelRepository>
		implements IPcStoreLevelService {

}
