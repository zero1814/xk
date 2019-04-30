package org.product.controller.product;

import org.product.service.product.IPcSkuStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.product.controller.BaseController;
import org.product.entity.product.PcSkuStatus;

@RestController
@RequestMapping("/product/sku/status/")
public class PcSkuStatusController extends BaseController<PcSkuStatus, IPcSkuStatusService> {

}
