package org.product.service.product;

import org.product.entity.product.PcProduct;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.EntityResult;

/**
 * 
 * 类: IPcProductService <br>
 * 描述: 商品业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:47:32
 */
public interface IPcProductService extends IBaseService<PcProduct, String> {

	/**
	 * 
	 * 方法: getProduct <br>
	 * 描述: 根据编码查询商品信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月12日 上午11:39:09
	 * 
	 * @param code
	 * @return
	 */
	EntityResult<PcProduct> getProduct(String code);
}
