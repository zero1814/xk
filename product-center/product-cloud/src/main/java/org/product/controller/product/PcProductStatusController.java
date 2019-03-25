package org.product.controller.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.product.service.product.IPcProductStatusService;

import org.product.controller.FlagEnabledController;
import org.product.entity.product.PcProductStatus;

@RestController
@RequestMapping("/product/status/")
public class PcProductStatusController extends FlagEnabledController<PcProductStatus, IPcProductStatusService> {

}
