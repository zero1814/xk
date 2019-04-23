package org.system.controller.role;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.FlagEnabledController;
import org.system.entity.role.ScPermission;
import org.system.service.role.IScPermissionService;

import io.swagger.annotations.Api;

/**
 * 
 * 类: ScApiInfoController <br>
 * 描述: 系统接口管理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:53:13
 */
@Api(tags="系统权限管理")
@RestController
@RequestMapping("/permission/")
public class ScPermissionController extends FlagEnabledController<ScPermission, IScPermissionService> {

}
