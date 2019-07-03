package org.product.service.store;

import org.product.entity.store.PcStoreStatus;
import org.zero.spring.jpa.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: IPcStoreStatusService <br>
 * 描述: 店铺状态业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:48:39
 */
public interface IPcStoreStatusService extends IBaseService<PcStoreStatus, String> {

	DataResult<PcStoreStatus> statusAll();
}
