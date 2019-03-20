package org.system.controller.role;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.FlagEnabledController;
import org.system.entity.role.ScSystemInfo;
import org.system.service.role.IScSystemInfoService;

/**
 * 
 * 类: ScSystemInfoController <br>
 * 描述: 系统中心接口 作者: zhy<br>
 * 时间: 2019年3月19日 下午3:47:47
 */
@RestController
@RequestMapping("/system/permission/system/")
public class ScSystemInfoController extends FlagEnabledController<ScSystemInfo, IScSystemInfoService> {

}
