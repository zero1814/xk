package org.system.service.impl;

import org.springframework.stereotype.Service;
import org.system.dto.ScUserInfoDto;
import org.system.entity.ScUserInfo;
import org.system.mapper.ScUserInfoMapper;
import org.zero.spring.mybatis.BaseServiceImpl;

@Service
public class ScUserInfoServiceImpl extends BaseServiceImpl<ScUserInfo, ScUserInfoMapper, ScUserInfoDto> {

}
