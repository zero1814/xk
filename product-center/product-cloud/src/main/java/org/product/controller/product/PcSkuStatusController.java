package org.product.controller.product;

import org.product.service.product.IPcSkuStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import org.zero.spring.jpa.BaseController;
import org.product.entity.product.PcSkuStatus;

@RestController
@RequestMapping("/product/sku/status/")
@Api(tags = "商品sku状态相关")
public class PcSkuStatusController extends BaseController<PcSkuStatus, IPcSkuStatusService> {

}
