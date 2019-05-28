package org.product.service.product;

import org.product.entity.product.PcSkuStatus;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: IPcSkuStatusService <br>
 * 描述: 商品sku状态业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:48:13
 */
public interface IPcSkuStatusService extends IBaseService<PcSkuStatus, String> {

	/**
	 * 
	 * 方法: statusAll <br>
	 * 描述: 查询所有可用状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:47:14
	 * 
	 * @return
	 */
	DataResult<PcSkuStatus> statusAll();
}
