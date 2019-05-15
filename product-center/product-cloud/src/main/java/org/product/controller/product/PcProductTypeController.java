package org.product.controller.product;

import org.product.controller.FlagEnabledController;
import org.product.entity.product.PcProductType;
import org.product.service.product.IPcProductTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/product/type/")
@Api(tags = "商品类型相关")
public class PcProductTypeController extends FlagEnabledController<PcProductType, IPcProductTypeService> {

}
