package org.system.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.system.entity.ScUser;
import org.system.entity.ScRole;
import org.zero.spring.jpa.BaseRepository;

public interface ScUserRepository extends BaseRepository<ScUser, String> {

	@Query("from ScUser where username=:username")
	ScUser findByUserName(String userName);
	
	@Query("select sa.roles from ScUser as sa where sa.code=:code")
	Set<ScRole> getRoles(@Param("code") String code);
}
