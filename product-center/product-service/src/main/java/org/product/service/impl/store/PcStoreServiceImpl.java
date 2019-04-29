package org.product.service.impl.store;

import org.product.entity.store.PcStore;
import org.product.repository.store.PcStoreRepository;
import org.product.service.store.IPcStoreService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcStoreServiceImpl <br>
 * 描述: 店铺业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:18
 */
@Service
public class PcStoreServiceImpl extends BaseServiceImpl<PcStore, String, PcStoreRepository> implements IPcStoreService {

}
