package org.customer.jwt.service.impl;

import org.customer.jwt.model.ScUser;
import org.customer.jwt.repository.ScUserRepository;
import org.customer.jwt.service.IScUserService;
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
