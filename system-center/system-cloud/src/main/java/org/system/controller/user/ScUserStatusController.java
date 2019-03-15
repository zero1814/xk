package org.system.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.BaseController;
import org.system.entity.user.ScUserStatus;
import org.system.service.user.IScUserStatusService;

@RestController
@RequestMapping("/system/user/status/")
public class ScUserStatusController extends BaseController<ScUserStatus, IScUserStatusService> {

}
