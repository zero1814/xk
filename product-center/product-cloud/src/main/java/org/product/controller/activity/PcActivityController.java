package org.product.controller.activity;

import org.product.controller.BaseController;
import org.product.entity.activity.PcActivity;
import org.product.service.activity.IPcActivityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity/")
public class PcActivityController extends BaseController<PcActivity, IPcActivityService>{

}
