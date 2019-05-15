package org.product.controller.store;

import org.product.controller.FlagEnabledController;
import org.product.entity.store.PcStoreType;
import org.product.service.store.IPcStoreTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/store/type/")
@Api(tags = "店铺类型相关")
public class PcStoreTypeController extends FlagEnabledController<PcStoreType, IPcStoreTypeService> {

}
