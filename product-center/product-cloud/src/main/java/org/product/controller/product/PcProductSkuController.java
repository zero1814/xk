package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.sku.PcSku;
import org.product.service.product.IPcProductSkuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/sku/")
public class PcProductSkuController extends BaseController<PcSku, IPcProductSkuService> {

}
