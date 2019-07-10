package org.customer.jwt.repository;

import org.customer.jwt.model.ScUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScUserRepository extends JpaRepository<ScUser, Long> {

	@Query("from ScUser where userName=:userName")
	ScUser findByUserName(@Param("userName") String userName);
}
