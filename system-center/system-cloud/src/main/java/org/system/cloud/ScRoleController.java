package org.system.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.entity.ScRole;
import org.system.service.IScRoleService;
import org.zero.spring.jpa.BaseController;

@RestController
@RequestMapping("/role/")
public class ScRoleController extends BaseController<ScRole, IScRoleService> {

}
