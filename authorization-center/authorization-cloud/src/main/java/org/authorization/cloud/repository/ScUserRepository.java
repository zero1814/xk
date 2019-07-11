package org.authorization.cloud.repository;

import org.authorization.cloud.entity.ScUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface ScUserRepository extends BaseRepository<ScUser, String> {

	@Query("from ScUser where username=:username")
	ScUser findByUsername(@Param("username") String username);
}
