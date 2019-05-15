package org.product.controller.product;

import org.product.controller.FlagEnabledController;
import org.product.entity.product.PcProductStatus;
import org.product.service.product.IPcProductStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/product/status/")
@Api(tags = "商品状态相关")
public class PcProductStatusController extends FlagEnabledController<PcProductStatus, IPcProductStatusService> {

}
