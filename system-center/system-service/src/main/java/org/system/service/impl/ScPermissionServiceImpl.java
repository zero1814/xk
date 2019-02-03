package org.system.service.impl;

import org.springframework.stereotype.Service;
import org.system.dto.ScPermissionDto;
import org.system.entity.ScPermission;
import org.system.mapper.ScPermissionMapper;
import org.system.service.IScPermissionService;
import org.zero.spring.mybatis.BaseServiceImpl;

@Service
public class ScPermissionServiceImpl extends BaseServiceImpl<ScPermission, ScPermissionMapper, ScPermissionDto>
		implements IScPermissionService {

}
