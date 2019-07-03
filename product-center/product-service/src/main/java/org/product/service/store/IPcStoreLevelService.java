package org.product.service.store;

import org.product.entity.store.PcStoreLevel;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: IPcStoreLevelService <br>
 * 描述: 店铺等级业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:48:26
 */
public interface IPcStoreLevelService extends IBaseService<PcStoreLevel, String> {

	/**
	 * 
	 * 方法: levelAll <br>
	 * 描述: 查询可用的店铺等级 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午11:21:10
	 * @return
	 */
	DataResult<PcStoreLevel> levelAll();
}
