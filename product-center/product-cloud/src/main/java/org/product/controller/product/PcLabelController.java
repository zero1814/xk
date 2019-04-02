package org.product.controller.product;

import org.product.controller.FlagEnabledController;
import org.product.entity.label.PcLabel;
import org.product.service.product.IPcLabelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/label/")
public class PcLabelController extends FlagEnabledController<PcLabel, IPcLabelService> {

}
