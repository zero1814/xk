package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProduct;
import org.product.service.product.IPcProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
public class PcProductController extends BaseController<PcProduct, IPcProductService>{

}
