package org.product.controller.activity;

import org.zero.spring.jpa.BaseController;
import org.product.entity.activity.PcActivity;
import org.product.service.activity.IPcActivityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/activity/")
@Api(tags = "活动相关")
public class PcActivityController extends BaseController<PcActivity, IPcActivityService> {

}
