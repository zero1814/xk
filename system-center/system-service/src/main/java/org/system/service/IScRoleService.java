package org.system.service;

import org.system.entity.ScPermission;
import org.system.entity.ScRole;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

public interface IScRoleService extends IBaseService<ScRole, String> {

	DataResult<ScPermission> getPermissions(String code);
}
