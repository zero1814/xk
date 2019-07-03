package org.system.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.system.entity.ScPermission;
import org.system.entity.ScRole;
import org.zero.spring.jpa.BaseRepository;

public interface ScRoleRepository extends BaseRepository<ScRole, String> {

	@Query("select sr.permissions from ScRole as sr where sr.code=:code")
	Set<ScPermission> getPermissions(@Param("code") String code);
}
