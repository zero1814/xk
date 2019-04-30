package org.product.controller.store;

import org.product.controller.FlagEnabledController;
import org.product.entity.store.PcStoreStatus;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/status/")
public class PcStoreStatusController extends FlagEnabledController<PcStoreStatus, IPcStoreStatusService> {

}
