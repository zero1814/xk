package org.system.service.impl;

import org.springframework.stereotype.Service;
import org.system.dto.ScRoleMenuDto;
import org.system.entity.ScRoleMenu;
import org.system.mapper.ScRoleMenuMapper;
import org.system.service.IScRoleMenuService;
import org.zero.spring.mybatis.BaseServiceImpl;

@Service
public class ScRoleMenuServiceImpl extends BaseServiceImpl<ScRoleMenu, ScRoleMenuMapper, ScRoleMenuDto>
		implements IScRoleMenuService {

}
