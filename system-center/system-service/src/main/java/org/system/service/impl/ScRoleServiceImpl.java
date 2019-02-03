package org.system.service.impl;

import org.springframework.stereotype.Service;
import org.system.dto.ScRoleDto;
import org.system.entity.ScRole;
import org.system.mapper.ScRoleMapper;
import org.system.service.IScRoleService;
import org.zero.spring.mybatis.BaseServiceImpl;

@Service
public class ScRoleServiceImpl extends BaseServiceImpl<ScRole, ScRoleMapper, ScRoleDto> implements IScRoleService {

}
