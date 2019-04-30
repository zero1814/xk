package org.product.controller.store;

import org.product.controller.BaseController;
import org.product.entity.store.PcStore;
import org.product.service.store.IPcStoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/")
public class PcStoreController extends BaseController<PcStore, IPcStoreService> {

}
