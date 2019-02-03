package org.system.service.impl;

import org.springframework.stereotype.Service;
import org.system.dto.ScUserRoleDto;
import org.system.entity.ScUserRole;
import org.system.mapper.ScUserRoleMapper;
import org.system.service.IScUserRoleService;
import org.zero.spring.mybatis.BaseServiceImpl;

@Service
public class ScUserRoleServiceImpl extends BaseServiceImpl<ScUserRole, ScUserRoleMapper, ScUserRoleDto>
		implements IScUserRoleService {

}
