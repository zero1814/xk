package org.product.service.product;

import java.util.List;

import org.product.entity.product.PcProductAttribute;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

public interface IPcProductAttributeService extends IBaseService<PcProductAttribute, String> {

	/**
	 * 
	 * 方法: arrange <br>
	 * 描述: 整理商品属性 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月17日 下午4:48:19
	 * 
	 * @return
	 */
	DataResult<PcProductAttribute> reorganize(List<PcProductAttribute> attributes);
}
