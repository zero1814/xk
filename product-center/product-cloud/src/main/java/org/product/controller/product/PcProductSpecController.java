package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductSpec;
import org.product.service.product.IPcProductSpecService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/product/spec/")
@Api(tags = "商品规格相关")
public class PcProductSpecController extends BaseController<PcProductSpec, IPcProductSpecService> {

}
