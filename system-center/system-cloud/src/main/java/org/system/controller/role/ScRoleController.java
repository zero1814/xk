package org.system.controller.role;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.FlagEnabledController;
import org.system.entity.role.ScRole;
import org.system.service.role.IScRoleService;

/**
 * 
 * 类: ScRoleController <br>
 * 描述: 系统角色接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:52:00
 */
@RestController
@RequestMapping("/system/role/")
public class ScRoleController extends FlagEnabledController<ScRole, IScRoleService> {

}
