package org.product.controller.product;

import org.zero.spring.jpa.BaseController;
import org.product.entity.product.PcSku;
import org.product.service.product.IPcSkuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/product/sku/")
@Api(tags = "商品sku相关")
public class PcSkuController extends BaseController<PcSku, IPcSkuService> {

}
