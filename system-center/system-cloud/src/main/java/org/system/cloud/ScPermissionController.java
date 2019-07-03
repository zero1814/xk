package org.system.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.entity.ScPermission;
import org.system.service.IScPermissionService;
import org.zero.spring.jpa.BaseController;

@RestController
@RequestMapping("/permission/")
public class ScPermissionController extends BaseController<ScPermission, IScPermissionService> {

}
