package org.product.service.impl.store;

import java.util.List;

import org.product.entity.store.PcStoreStatus;
import org.product.repository.store.PcStoreStatusRepository;
import org.product.service.store.IPcStoreStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcStoreStatusServiceImpl <br>
 * 描述: 店铺状态业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:26
 */
@Service
public class PcStoreStatusServiceImpl extends BaseServiceImpl<PcStoreStatus, String, PcStoreStatusRepository>
		implements IPcStoreStatusService {

	@Autowired
	private PcStoreStatusRepository repository;

	@Override
	public DataResult<PcStoreStatus> statusAll() {
		DataResult<PcStoreStatus> result = new DataResult<PcStoreStatus>();
		try {
			List<PcStoreStatus> list = repository.all();
			if (list.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询为空");
				return result;
			}
			result.setCode(ResultType.SUCCESS);
			result.setData(list);
			result.setTotal(Long.valueOf(list.size()));
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询报错");
		}
		return result;
	}

}
