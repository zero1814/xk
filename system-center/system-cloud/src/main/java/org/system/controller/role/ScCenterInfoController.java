package org.system.controller.role;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.BaseController;
import org.system.entity.role.ScCenterInfo;
import org.system.service.role.IScCenterInfoService;

@RestController
@RequestMapping("/system/center/")
public class ScCenterInfoController extends BaseController<ScCenterInfo, IScCenterInfoService> {

}
