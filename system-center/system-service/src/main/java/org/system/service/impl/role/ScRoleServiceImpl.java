package org.system.service.impl.role;

import org.springframework.stereotype.Service;
import org.system.entity.role.ScRole;
import org.system.repository.role.ScRoleRepository;
import org.system.service.role.IScRoleService;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: ScRoleServiceImpl <br>
 * 描述: 系统角色表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午2:02:47
 */
@Service
public class ScRoleServiceImpl extends BaseServiceImpl<ScRole, String, ScRoleRepository> implements IScRoleService {

}
