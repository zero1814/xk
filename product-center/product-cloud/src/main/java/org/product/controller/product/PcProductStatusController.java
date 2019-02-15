package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductStatus;
import org.product.service.product.IPcProductStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/status/")
public class PcProductStatusController extends BaseController<PcProductStatus, IPcProductStatusService>{

}
