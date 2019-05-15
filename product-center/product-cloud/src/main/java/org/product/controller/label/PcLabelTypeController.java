package org.product.controller.label;

import org.product.controller.BaseController;
import org.product.entity.label.PcLabelType;
import org.product.service.label.IPcLabelTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/label/type/")
@Api(tags = "商品标签类型相关")
public class PcLabelTypeController extends BaseController<PcLabelType, IPcLabelTypeService> {

}
