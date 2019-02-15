package org.product.controller.sku;

import org.product.controller.BaseController;
import org.product.entity.sku.PcSkuInfo;
import org.product.service.sku.IPcSkuInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/sku/")
public class PcSkuInfoController extends BaseController<PcSkuInfo, IPcSkuInfoService> {

}
