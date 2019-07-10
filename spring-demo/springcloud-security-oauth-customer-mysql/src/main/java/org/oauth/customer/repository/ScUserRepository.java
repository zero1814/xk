package org.oauth.customer.repository;

import org.oauth.customer.model.ScUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScUserRepository extends JpaRepository<ScUser, Long> {

}
