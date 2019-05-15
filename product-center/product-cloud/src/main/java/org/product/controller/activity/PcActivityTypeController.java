package org.product.controller.activity;

import org.product.controller.BaseController;
import org.product.entity.activity.PcActivityType;
import org.product.service.activity.IPcActivityTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/activity/type/")
@Api(tags = "活动类型相关")
public class PcActivityTypeController extends BaseController<PcActivityType, IPcActivityTypeService> {

}
