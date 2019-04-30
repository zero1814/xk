package org.product.service.impl.store;

import org.product.entity.store.PcStoreType;
import org.product.repository.store.PcStoreTypeRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.store.IPcStoreTypeService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PcStoreTypeServiceImpl <br>
 * 描述: 店铺类型业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:35
 */
@Service
public class PcStoreTypeServiceImpl extends FlagEnabledServiceImpl<PcStoreType, String, PcStoreTypeRepository>
		implements IPcStoreTypeService {

}
