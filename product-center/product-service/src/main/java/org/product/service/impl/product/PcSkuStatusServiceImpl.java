package org.product.service.impl.product;

import java.util.List;

import org.product.entity.product.PcSkuStatus;
import org.product.repository.product.PcSkuStatusRepository;
import org.product.service.product.IPcSkuStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcSkuStatusServiceImpl <br>
 * 描述: 商品sku业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:00
 */
@Service
public class PcSkuStatusServiceImpl extends BaseServiceImpl<PcSkuStatus, String, PcSkuStatusRepository>
		implements IPcSkuStatusService {

	@Autowired
	private PcSkuStatusRepository repository;

	/**
	 * 
	 * 方法: statusAll <br>
	 * 
	 * @return
	 * @see org.product.service.product.IPcSkuStatusService#statusAll()
	 */
	@Override
	public DataResult<PcSkuStatus> statusAll() {
		DataResult<PcSkuStatus> result = new DataResult<PcSkuStatus>();
		try {
			List<PcSkuStatus> list = repository.all();
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
