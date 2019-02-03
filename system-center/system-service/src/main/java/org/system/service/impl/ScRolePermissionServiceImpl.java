package org.system.service.impl;

import org.springframework.stereotype.Service;
import org.system.dto.ScRolePermissionDto;
import org.system.entity.ScRolePermission;
import org.system.mapper.ScRolePermissionMapper;
import org.system.service.IScRolePermissionService;
import org.zero.spring.mybatis.BaseServiceImpl;

@Service
public class ScRolePermissionServiceImpl
		extends BaseServiceImpl<ScRolePermission, ScRolePermissionMapper, ScRolePermissionDto>
		implements IScRolePermissionService {

}
