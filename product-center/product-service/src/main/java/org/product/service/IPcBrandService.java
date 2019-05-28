package org.product.service;


import org.product.entity.PcBrand;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: IPcBrandService <br>
 * 描述: 品牌业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:48:55
 */
public interface IPcBrandService extends IBaseService<PcBrand, String> {

	/**
	 * 
	 * 方法: brandAll <br>
	 * 描述: 查询可用品牌 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:55:34
	 * 
	 * @return
	 */
	DataResult<PcBrand> brandAll();
}
