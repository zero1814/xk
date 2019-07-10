package org.oauth2.jwt.repository;

import org.oauth2.jwt.model.ScUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScUserRepository extends JpaRepository<ScUser, String> {

	@Query("from ScUser where userName=:userName")
	ScUser findByUserName(@Param("userName") String userName);
}
