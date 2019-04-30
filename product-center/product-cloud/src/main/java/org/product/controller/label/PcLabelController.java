package org.product.controller.label;

import org.product.controller.FlagEnabledController;
import org.product.entity.label.PcLabel;
import org.product.service.label.IPcLabelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/label/")
public class PcLabelController extends FlagEnabledController<PcLabel, IPcLabelService> {

}
