package org.product.controller.sku;

import org.product.controller.BaseController;
import org.product.entity.sku.PcSkuType;
import org.product.service.sku.IPcSkuTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/sku/type/")
public class PcSkuTypeController extends BaseController<PcSkuType, IPcSkuTypeService> {

}
