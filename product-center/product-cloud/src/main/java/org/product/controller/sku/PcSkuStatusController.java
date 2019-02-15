package org.product.controller.sku;

import org.product.controller.BaseController;
import org.product.entity.sku.PcSkuStatus;
import org.product.service.sku.IPcSkuStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/sku/status/")
public class PcSkuStatusController extends BaseController<PcSkuStatus, IPcSkuStatusService> {

}
