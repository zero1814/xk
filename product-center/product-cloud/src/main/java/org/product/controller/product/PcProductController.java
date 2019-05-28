package org.product.controller.product;

import org.zero.spring.jpa.BaseController;
import org.product.entity.product.PcProduct;
import org.product.service.product.IPcProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/product/")
@Api(tags = "商品相关")
public class PcProductController extends BaseController<PcProduct, IPcProductService>{

}
