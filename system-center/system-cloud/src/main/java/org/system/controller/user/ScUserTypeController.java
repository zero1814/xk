package org.system.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.BaseController;
import org.system.entity.user.ScUserType;
import org.system.service.user.IScUserTypeService;

@RestController
@RequestMapping("/system/user/type/")
public class ScUserTypeController extends BaseController<ScUserType, IScUserTypeService> {

}
