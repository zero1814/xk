package org.product.controller.activity;

import org.product.controller.BaseController;
import org.product.entity.activity.PcActivityProduct;
import org.product.service.activity.IPcActivityProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity/product/")
public class PcActivityProductController extends BaseController<PcActivityProduct, IPcActivityProductService> {

}
