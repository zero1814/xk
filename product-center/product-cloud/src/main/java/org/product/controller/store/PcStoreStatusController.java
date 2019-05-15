package org.product.controller.store;

import org.product.controller.FlagEnabledController;
import org.product.entity.store.PcStoreStatus;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/store/status/")
@Api(tags = "店铺状态相关")
public class PcStoreStatusController extends FlagEnabledController<PcStoreStatus, IPcStoreStatusService> {

}
