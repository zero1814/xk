package org.product.service.impl.store;

import org.product.entity.store.PcStoreLevel;
import org.product.repository.store.PcStoreLevelRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.store.IPcStoreLevelService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PcStoreLevelServiceImpl <br>
 * 描述: 店铺等级业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:09
 */
@Service
public class PcStoreLevelServiceImpl extends FlagEnabledServiceImpl<PcStoreLevel, String, PcStoreLevelRepository>
		implements IPcStoreLevelService {

}
