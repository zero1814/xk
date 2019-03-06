package org.product.service.product;

import org.product.entity.product.PcProductInfo;
import org.product.result.PcProductResult;
import org.zero.spring.jpa.IBaseService;

public interface IPcProductInfoService extends IBaseService<PcProductInfo, String> {

	/**
	 * 
	 * 方法: initProperties <br>
	 * 描述: 初始化加载商品相关参数 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年3月6日 下午4:36:03
	 * 
	 * @return
	 */
	PcProductResult initProperties();
}
