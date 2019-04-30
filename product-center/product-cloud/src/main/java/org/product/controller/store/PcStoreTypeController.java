package org.product.controller.store;

import org.product.controller.FlagEnabledController;
import org.product.entity.store.PcStoreType;
import org.product.service.store.IPcStoreTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/type/")
public class PcStoreTypeController extends FlagEnabledController<PcStoreType, IPcStoreTypeService> {

}
