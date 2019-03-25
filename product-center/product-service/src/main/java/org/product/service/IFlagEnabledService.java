package org.product.service;

import org.zero.spring.jpa.BaseEntity;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.BaseResult;

/**
 * 
 * 类: IFlagEnabledService <br>
 * 描述: 修改是否可用，主要 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 下午3:19:54
 * @param <T>
 * @param <ID>
 */
public interface IFlagEnabledService<T extends BaseEntity,ID> extends IBaseService<T, ID>{

	BaseResult updateFlagEnabled(T entity);
}
