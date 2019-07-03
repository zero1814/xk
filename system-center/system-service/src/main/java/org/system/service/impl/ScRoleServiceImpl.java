package org.system.service.impl;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.ScPermission;
import org.system.entity.ScRole;
import org.system.repository.ScRoleRepository;
import org.system.service.IScRoleService;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

@Service
public class ScRoleServiceImpl extends BaseServiceImpl<ScRole, String, ScRoleRepository> implements IScRoleService {

	@Autowired
	private ScRoleRepository repository;

	@Override
	public DataResult<ScPermission> getPermissions(String code) {
		DataResult<ScPermission> result = new DataResult<ScPermission>();
		try {
			Set<ScPermission> permissions = repository.getPermissions(code);
			if (permissions == null || permissions.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询为空");
				return result;
			}
			result.setData(new ArrayList<ScPermission>(permissions));
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询报错");
		}
		return result;
	}

}
