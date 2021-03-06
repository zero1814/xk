package org.product.service.category;

import org.product.entity.category.PcCategory;
import org.product.entity.category.PcCategoryAttribute;
import org.product.entity.category.PcCategorySpecification;
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

	/**
	 * 
	 * 方法: categoryData <br>
	 * 描述: 查询所有可用分类 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月4日 下午2:28:06
	 * 
	 * @return
	 */
	DataResult<PcCategory> categoryData();

	/***
	 * 
	 * 方法: getSpecifications <br>
	 * 描述: 获取分类规格参数 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月30日 下午3:18:44
	 * 
	 * @param category
	 * @return
	 */
	DataResult<PcCategorySpecification> getSpecifications(String category);

	/**
	 * 
	 * 方法: getAttributes <br>
	 * 描述: 获取分类属性参数 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月30日 下午3:19:11
	 * 
	 * @param category
	 * @return
	 */
	DataResult<PcCategoryAttribute> getAttributes(String category);
}
