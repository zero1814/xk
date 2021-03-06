package org.product.service.product;

import org.product.entity.product.PcProductStatus;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: IPcProductStatusService <br>
 * 描述: 商品状态业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:47:48
 */
public interface IPcProductStatusService extends IBaseService<PcProductStatus, String> {

	/**
	 * 
	 * 方法: statusAll <br>
	 * 描述: 查询可用的商品状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:33:55
	 * 
	 * @return
	 */
	public DataResult<PcProductStatus> statusAll(Integer type);
}
