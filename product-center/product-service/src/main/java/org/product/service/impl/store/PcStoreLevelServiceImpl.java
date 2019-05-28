package org.product.service.impl.store;

import java.util.List;

import org.product.entity.store.PcStoreLevel;
import org.product.repository.store.PcStoreLevelRepository;
import org.product.service.store.IPcStoreLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcStoreLevelServiceImpl <br>
 * 描述: 店铺等级业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:09
 */
@Service
public class PcStoreLevelServiceImpl extends BaseServiceImpl<PcStoreLevel, String, PcStoreLevelRepository>
		implements IPcStoreLevelService {

	@Autowired
	private PcStoreLevelRepository repository;

	@Override
	public DataResult<PcStoreLevel> levelAll() {
		DataResult<PcStoreLevel> result = new DataResult<PcStoreLevel>();
		try {
			List<PcStoreLevel> list = repository.all();
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
