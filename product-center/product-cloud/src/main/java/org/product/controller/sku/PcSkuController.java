package org.product.controller.sku;

import org.product.controller.BaseController;
import org.product.entity.sku.PcSku;
import org.product.service.sku.IPcProductSkuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sku/")
public class PcSkuController extends BaseController<PcSku, IPcProductSkuService> {

}
