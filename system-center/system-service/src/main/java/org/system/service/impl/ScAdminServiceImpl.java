package org.system.service.impl;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.ScAdmin;
import org.system.entity.ScRole;
import org.system.repository.ScAdminRepository;
import org.system.service.IScAdminService;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

@Service
public class ScAdminServiceImpl extends BaseServiceImpl<ScAdmin, String, ScAdminRepository> implements IScAdminService {

	@Autowired
	private ScAdminRepository repository;

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

}
