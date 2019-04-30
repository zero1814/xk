package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductSpec;
import org.product.service.product.IPcProductSpecService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/spec/")
public class PcProductSpecController extends BaseController<PcProductSpec, IPcProductSpecService> {

}
