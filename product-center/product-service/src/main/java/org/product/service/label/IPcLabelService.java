package org.product.service.label;

import org.product.entity.PcLabel;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: IPcLabelService <br>
 * 描述: 标签业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:47:08
 */
public interface IPcLabelService extends IBaseService<PcLabel, String> {

	/**
	 * 
	 * 方法: labels <br>
	 * 描述: 根据类型查询可用店铺等级 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午10:27:45
	 * 
	 * @param type
	 * @return
	 */
	public DataResult<PcLabel> labels(Integer type);
}
