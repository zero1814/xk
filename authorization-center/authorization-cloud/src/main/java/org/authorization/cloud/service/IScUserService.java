package org.authorization.cloud.service;

import org.authorization.cloud.entity.ScUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.zero.spring.jpa.IBaseService;

public interface IScUserService extends IBaseService<ScUser, String>, UserDetailsService {

}
