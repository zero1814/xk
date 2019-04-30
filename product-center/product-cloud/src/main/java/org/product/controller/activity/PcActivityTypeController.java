package org.product.controller.activity;

import org.product.controller.BaseController;
import org.product.entity.activity.PcActivityType;
import org.product.service.activity.IPcActivityTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity/type/")
public class PcActivityTypeController extends BaseController<PcActivityType, IPcActivityTypeService> {

}
