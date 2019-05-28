package org.product.controller.store;

import org.zero.spring.jpa.BaseController;
import org.product.entity.store.PcStoreLevel;
import org.product.service.store.IPcStoreLevelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/store/level/")
@Api(tags = "店铺等级相关")
public class PcStoreLevelController extends BaseController<PcStoreLevel, IPcStoreLevelService> {

}
