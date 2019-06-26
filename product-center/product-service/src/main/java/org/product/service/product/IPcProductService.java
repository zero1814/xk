package org.product.service.product;

import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductAttribute;
import org.product.entity.product.PcProductSpecification;
import org.product.entity.product.PcSku;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.DataResult;
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

	/**
	 * 
	 * 方法: getSpecification <br>
	 * 描述: 查询商品编码查询商品参数列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月18日 下午3:15:16
	 * 
	 * @param code
	 * @return
	 */
	DataResult<PcProductSpecification> getSpecification(String code);

	/**
	 * 
	 * 方法: getAttribute <br>
	 * 描述: 查询商品编码查询商品属性列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月18日 下午3:15:33
	 * 
	 * @param code
	 * @return
	 */
	DataResult<PcProductAttribute> getAttribute(String code);

	/**
	 * 
	 * 方法: getSkuList <br>
	 * 描述: 获取商品SKU列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月18日 下午4:21:29
	 * 
	 * @param code
	 * @return
	 */
	DataResult<PcSku> getSkuList(String code);

	/**
	 * 
	 * 方法: skuConcatAttribute <br>
	 * 描述: 查询商品属性是否已经绑定sku商品 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月25日 上午11:48:33
	 * 
	 * @param attributeCode
	 * @return
	 */
	BaseResult skuConcatAttribute(String attributeCode);
}
