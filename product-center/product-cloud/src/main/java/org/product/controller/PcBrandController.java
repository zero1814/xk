package org.product.controller;

import org.product.entity.PcBrand;
import org.product.service.IPcBrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
@RestController
@RequestMapping("/brand/")
@Api(tags = "商品品牌相关")
public class PcBrandController extends FlagEnabledController<PcBrand, IPcBrandService> {

}
