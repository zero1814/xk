package org.system.service.impl;

import org.springframework.stereotype.Service;
import org.system.dto.ScMenuDto;
import org.system.entity.ScMenu;
import org.system.mapper.ScMenuMapper;
import org.system.service.IScMenuService;
import org.zero.spring.mybatis.BaseServiceImpl;

@Service
public class ScMenuServiceImpl extends BaseServiceImpl<ScMenu, ScMenuMapper, ScMenuDto> implements IScMenuService {

}
