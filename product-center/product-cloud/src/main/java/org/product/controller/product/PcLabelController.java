package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcLabel;
import org.product.service.product.IPcLabelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/label/")
public class PcLabelController extends BaseController<PcLabel, IPcLabelService> {

}
