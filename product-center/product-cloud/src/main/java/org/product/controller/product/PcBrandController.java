package org.product.controller.product;

import org.product.controller.FlagEnabledController;
import org.product.entity.product.PcBrand;
import org.product.service.product.IPcBrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand/")
public class PcBrandController extends FlagEnabledController<PcBrand, IPcBrandService> {

}
