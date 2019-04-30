package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcSku;
import org.product.service.product.IPcSkuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/sku/")
public class PcSkuController extends BaseController<PcSku, IPcSkuService> {

}
