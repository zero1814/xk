package org.product.service.impl.store;

import org.product.entity.store.PcStoreStatus;
import org.product.repository.store.PcStoreStatusRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PcStoreStatusServiceImpl <br>
 * 描述: 店铺状态业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:26
 */
@Service
public class PcStoreStatusServiceImpl extends FlagEnabledServiceImpl<PcStoreStatus, String, PcStoreStatusRepository>
		implements IPcStoreStatusService {

}
