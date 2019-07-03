package org.product.service.impl.product;

import java.util.List;

import org.product.entity.product.PcProductStatus;
import org.product.repository.product.PcProductStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

import org.product.service.product.IPcProductStatusService;

/**
 * 
 * 类: PcProductStatusServiceImpl <br>
 * 描述: 商品状态业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:36
 */
@Service
public class PcProductStatusServiceImpl extends BaseServiceImpl<PcProductStatus, String, PcProductStatusRepository>
		implements IPcProductStatusService {

	@Autowired
	private PcProductStatusRepository repository;

	@Override
	public DataResult<PcProductStatus> statusAll(Integer type) {
		DataResult<PcProductStatus> result = new DataResult<PcProductStatus>();
		try {
			List<PcProductStatus> list = repository.statusByType(type);
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
