package org.product.service.impl;

import java.util.List;

import org.product.entity.PcBrand;
import org.product.repository.PcBrandRepository;
import org.product.service.IPcBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcBrandServiceImpl <br>
 * 描述: 品牌业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:43
 */
@Service
public class PcBrandServiceImpl extends BaseServiceImpl<PcBrand, String, PcBrandRepository> implements IPcBrandService {

	@Autowired
	private PcBrandRepository repository;

	@Override
	public DataResult<PcBrand> brandAll() {
		DataResult<PcBrand> result = new DataResult<PcBrand>();
		try {
			List<PcBrand> list = repository.brandAll();
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
