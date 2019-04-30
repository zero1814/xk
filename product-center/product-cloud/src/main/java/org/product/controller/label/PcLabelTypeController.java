package org.product.controller.label;

import org.product.controller.BaseController;
import org.product.entity.label.PcLabelType;
import org.product.service.label.IPcLabelTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/label/type/")
public class PcLabelTypeController extends BaseController<PcLabelType, IPcLabelTypeService> {

}
