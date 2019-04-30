package org.product.controller.product;

import org.product.controller.FlagEnabledController;
import org.product.entity.product.PcProductType;
import org.product.service.product.IPcProductTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/type/")
public class PcProductTypeController extends FlagEnabledController<PcProductType, IPcProductTypeService> {

}
