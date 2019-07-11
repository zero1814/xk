package org.system.service.impl;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.ScUser;
import org.system.entity.ScRole;
import org.system.repository.ScUserRepository;
import org.system.service.IScUserService;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@Service
public class ScUserServiceImpl extends BaseServiceImpl<ScUser, String, ScUserRepository> implements IScUserService {

	@Autowired
	private ScUserRepository repository;

	@Override
	public DataResult<ScRole> getRoles(String code) {
		DataResult<ScRole> result = new DataResult<ScRole>();
		try {
			Set<ScRole> roles = repository.getRoles(code);
			if (roles == null || roles.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询为空");
				return result;
			}
			result.setData(new ArrayList<ScRole>(roles));
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询报错");
		}
		return result;
	}

	@Override
	public EntityResult<ScUser> findByUserName(String userName) {
		EntityResult<ScUser> result = new EntityResult<ScUser>();
		try {
			ScUser user = repository.findByUserName(userName);
			if (user == null) {
				result.setCode(ResultType.NULL);
				result.setMessage("用户不存在");
				return result;
			}
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
			result.setEntity(user);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询报错");
		}
		return result;
	}

}
