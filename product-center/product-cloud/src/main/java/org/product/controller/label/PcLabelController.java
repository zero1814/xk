package org.product.controller.label;

import org.product.controller.FlagEnabledController;
import org.product.entity.product.PcLabel;
import org.product.service.label.IPcLabelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/label/")
@Api(tags = "商品标签相关")
public class PcLabelController extends FlagEnabledController<PcLabel, IPcLabelService> {

}
