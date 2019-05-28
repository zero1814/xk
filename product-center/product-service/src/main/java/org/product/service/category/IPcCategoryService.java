package org.product.service.category;

import org.product.entity.category.PcCategory;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: IPcCategoryService <br>
 * 描述: 分类业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:46:32
 */
public interface IPcCategoryService extends IBaseService<PcCategory, String> {

	/**
	 * 
	 * 方法: findParent <br>
	 * 描述: 查询可选的父级分类 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月21日 上午8:43:13
	 * 
	 * @param code
	 * @return
	 */
	DataResult<PcCategory> findParent(String code);
}
