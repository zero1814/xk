package org.product.service.impl.label;

import java.util.List;

import org.product.entity.PcLabel;
import org.product.repository.label.PcLabelRepository;
import org.product.service.label.IPcLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcLabelServiceImpl <br>
 * 描述: 标签业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:47
 */
@Service
public class PcLabelServiceImpl extends BaseServiceImpl<PcLabel, String, PcLabelRepository> implements IPcLabelService {

	@Autowired
	private PcLabelRepository repository;

	/**
	 * 
	 * 方法: labels <br>
	 * @param type
	 * @return 
	 * @see org.product.service.label.IPcLabelService#labels(java.lang.Integer)
	 */
	@Override
	public DataResult<PcLabel> labels(Integer type) {
		DataResult<PcLabel> result = new DataResult<PcLabel>();
		try {
			List<PcLabel> list = repository.all(type);
			if (list.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询可用标签为空");
				return result;
			}
			result.setCode(ResultType.SUCCESS);
			result.setData(list);
			result.setTotal(Long.valueOf(list.size()));
			result.setMessage("查询可用标签成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询可用标签报错");
		}
		return result;
	}

}
