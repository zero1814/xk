package org.system.controller.role;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.controller.BaseController;
import org.system.entity.role.ScApiInfo;
import org.system.service.role.IScApiInfoService;

/**
 * 
 * 类: ScApiInfoController <br>
 * 描述: 系统接口管理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:53:13
 */
@RestController
@RequestMapping("/system/api/")
public class ScApiInfoController extends BaseController<ScApiInfo, IScApiInfoService> {

}