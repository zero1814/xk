package org.oauth.customer.service.impl;

import org.oauth.customer.model.ScUser;
import org.oauth.customer.repository.ScUserRepository;
import org.oauth.customer.service.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ScUserServiceImpl implements IScUserService {

	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private ScUserRepository repository;

	@Override
	public ScUser create(ScUser entity) {
		String password = "{bcrypt}" + passwordEncoder.encode(entity.getPassword());
		entity.setPassword(password);
		ScUser user = repository.save(entity);
		return user;
	}

}
