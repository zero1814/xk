package org.product.service.impl.store;

import java.util.List;

import org.product.entity.store.PcStoreInfo;
import org.product.entity.store.PcStoreStatus;
import org.product.entity.store.PcStoreType;
import org.product.repository.store.PcStoreInfoRepository;
import org.product.repository.store.PcStoreStatusRepository;
import org.product.repository.store.PcStoreTypeRepository;
import org.product.result.store.PcStoreInfoResult;
import org.product.service.store.IPcStoreInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.ResultType;

@Service
public class PcStoreInfoServiceImpl extends BaseServiceImpl<PcStoreInfo, String, PcStoreInfoRepository>
		implements IPcStoreInfoService {

	private static final Logger logger = LoggerFactory.getLogger(PcStoreInfoServiceImpl.class);

	@Autowired
	private PcStoreTypeRepository typeRepository;
	@Autowired
	private PcStoreStatusRepository statusRepository;

	@Override
	public PcStoreInfoResult initProperty() {
		PcStoreInfoResult result = new PcStoreInfoResult();
		try {
			List<PcStoreType> typeList = typeRepository.findAll(Example.of(new PcStoreType(0)));
			List<PcStoreStatus> statusList = statusRepository.findAll(Example.of(new PcStoreStatus(0)));
			result.setTypeList(typeList);
			result.setStatusList(statusList);
			result.setCode(ResultType.SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("初始化店铺参数报错，错误原因：" + e.getMessage());
		}
		return result;
	}

}
