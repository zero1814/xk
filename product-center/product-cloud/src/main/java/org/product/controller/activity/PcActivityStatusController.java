package org.product.controller.activity;

import org.product.controller.FlagEnabledController;
import org.product.entity.activity.PcActivityStatus;
import org.product.service.activity.IPcActivityStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity/status/")
public class PcActivityStatusController extends FlagEnabledController<PcActivityStatus, IPcActivityStatusService> {

}
