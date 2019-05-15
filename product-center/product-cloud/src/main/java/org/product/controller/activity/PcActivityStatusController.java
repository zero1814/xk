package org.product.controller.activity;

import org.product.controller.FlagEnabledController;
import org.product.entity.activity.PcActivityStatus;
import org.product.service.activity.IPcActivityStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/activity/status/")
@Api(tags = "活动状态相关")
public class PcActivityStatusController extends FlagEnabledController<PcActivityStatus, IPcActivityStatusService> {

}
