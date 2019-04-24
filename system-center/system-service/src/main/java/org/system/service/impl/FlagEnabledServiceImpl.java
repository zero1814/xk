package org.system.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.system.entity.FlagEnabledEntity;
import org.system.service.IFlagEnabledService;
import org.zero.spring.jpa.BaseRepository;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.ResultType;

public class FlagEnabledServiceImpl<T extends FlagEnabledEntity, ID, R extends BaseRepository<T, ID>>
		extends BaseServiceImpl<T, ID, R> implements IFlagEnabledService<T, ID> {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BaseResult updateFlagEnabled(T entity) {
		BaseResult result = new BaseResult();
		try {
			String sql = "update " + entity.getClass().getName() + "set flag_enabled=:flag_enabled where code=:code";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter("flag_enabled", entity.getFlagEnabled());
			query.setParameter("code", entity.getCode());
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("修改状态报错，错误原因：" + e.getLocalizedMessage());
		}
		return result;
	}
}
