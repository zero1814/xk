package org.product.controller.store;

import org.zero.spring.jpa.BaseController;
import org.product.entity.store.PcStore;
import org.product.service.store.IPcStoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/store/")
@Api(tags = "店铺相关")
public class PcStoreController extends BaseController<PcStore, IPcStoreService> {

}
