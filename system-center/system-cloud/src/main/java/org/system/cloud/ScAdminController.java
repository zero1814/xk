package org.system.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.system.entity.ScAdmin;
import org.system.service.IScAdminService;
import org.zero.spring.jpa.BaseController;

@RestController
@RequestMapping("/admin/")
public class ScAdminController extends BaseController<ScAdmin, IScAdminService> {

}
