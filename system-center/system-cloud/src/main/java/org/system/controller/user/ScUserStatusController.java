package org.system.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.BaseController;
import org.system.entity.user.ScUserStatus;
import org.system.service.user.IScUserStatusService;

import io.swagger.annotations.Api;

@Api(tags="系统用户状态管理")
@RestController
@RequestMapping("/user/status/")
public class ScUserStatusController extends BaseController<ScUserStatus, IScUserStatusService> {

}
