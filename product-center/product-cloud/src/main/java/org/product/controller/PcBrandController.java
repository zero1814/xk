package org.product.controller;

import org.product.entity.PcBrand;
import org.product.service.IPcBrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/brand/")
public class PcBrandController extends FlagEnabledController<PcBrand, IPcBrandService> {

}
