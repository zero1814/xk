package org.system.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.system.entity.ScAdmin;
import org.system.entity.ScRole;
import org.zero.spring.jpa.BaseRepository;

public interface ScAdminRepository extends BaseRepository<ScAdmin, String> {

	@Query("select sa.roles from ScAdmin as sa where sa.code=:code")
	Set<ScRole> getRoles(@Param("code") String code);
}
