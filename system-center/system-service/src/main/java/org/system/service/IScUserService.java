package org.system.service;

import org.system.entity.ScUser;
import org.system.entity.ScRole;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.EntityResult;

public interface IScUserService extends IBaseService<ScUser, String> {

	EntityResult<ScUser> findByUserName(String userName);

	DataResult<ScRole> getRoles(String code);
}
