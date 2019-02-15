package org.product.service.impl.store;

import org.product.entity.store.PcStoreInfo;
import org.product.entity.store.PcStoreStatus;
import org.product.entity.store.PcStoreType;
import org.product.repository.store.PcStoreInfoRepository;
import org.product.repository.store.PcStoreStatusRepository;
import org.product.repository.store.PcStoreTypeRepository;
import org.product.service.store.IPcStoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@Service
public class PcStoreInfoServiceImpl extends BaseServiceImpl<PcStoreInfo, String, PcStoreInfoRepository>
		implements IPcStoreInfoService {

	@Autowired
	private PcStoreTypeRepository typeRepository;
	@Autowired
	private PcStoreStatusRepository statusRepository;

	@Override
	public EntityResult<PcStoreInfo> insert(PcStoreInfo entity) {
		EntityResult<PcStoreInfo> result = new EntityResult<PcStoreInfo>();
		PcStoreType type = typeRepository.findById(entity.getType().getCode()).get();
		if (type == null) {
			result.setCode(ResultType.NULL);
			result.setMessage("店铺类型不存在");
			return result;
		}
		entity.setType(type);
		PcStoreStatus status = statusRepository.findById(entity.getStatus().getCode()).get();
		if (status == null) {
			result.setCode(ResultType.NULL);
			result.setMessage("店铺状态不存在");
			return result;
		}
		entity.setStatus(status);
		return super.insert(entity);
	}

}
