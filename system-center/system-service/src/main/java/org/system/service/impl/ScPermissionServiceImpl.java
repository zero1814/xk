package org.system.service.impl;

import org.springframework.stereotype.Service;
import org.system.entity.ScPermission;
import org.system.repository.ScPermissionRepository;
import org.system.service.IScPermissionService;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class ScPermissionServiceImpl extends BaseServiceImpl<ScPermission, String, ScPermissionRepository>
		implements IScPermissionService {

}
