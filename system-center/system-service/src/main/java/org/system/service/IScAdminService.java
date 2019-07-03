package org.system.service;

import org.system.entity.ScAdmin;
import org.system.entity.ScRole;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

public interface IScAdminService extends IBaseService<ScAdmin, String> {

	DataResult<ScRole> getRoles(String code);
}
