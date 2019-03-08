package org.product.service.store;

import org.product.entity.store.PcStoreInfo;
import org.product.result.store.PcStoreInfoResult;
import org.zero.spring.jpa.IBaseService;

public interface IPcStoreInfoService extends IBaseService<PcStoreInfo, String> {

	/**
	 * 
	 * 方法: initProperty <br>
	 * 描述: 初始化加载店铺参数 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年3月7日 下午5:06:52
	 * @return
	 */
	PcStoreInfoResult initProperty();
}
