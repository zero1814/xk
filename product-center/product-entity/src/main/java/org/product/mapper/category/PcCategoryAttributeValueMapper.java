package org.product.mapper.category;

import java.util.List;

import org.product.dto.category.PcCategoryAttributeValueDto;
import org.product.entity.category.PcCategoryAttributeValue;
import org.zero.spring.mybatis.BaseMapper;

public interface PcCategoryAttributeValueMapper
		extends BaseMapper<PcCategoryAttributeValue, PcCategoryAttributeValueDto> {

	/**
	 * 
	 * 方法: selectByAttribute <br>
	 * 描述: 根据属性编号查询属性值 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月27日 上午8:58:28
	 * 
	 * @param attribute
	 * @return
	 */
	List<PcCategoryAttributeValue> selectByAttribute(String attribute);
}