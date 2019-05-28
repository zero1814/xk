package org.product.service.impl;

import java.util.List;

import org.product.entity.PcKeyword;
import org.product.repository.PcKeywordRepository;
import org.product.service.IPcKeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcKeywordsServiceImpl <br>
 * 描述: 常用关键字业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:52
 */
@Service
public class PcKeywordsServiceImpl extends BaseServiceImpl<PcKeyword, String, PcKeywordRepository>
		implements IPcKeywordsService {
	@Autowired
	private PcKeywordRepository repository;

	@Override
	public DataResult<PcKeyword> keywordAll() {
		DataResult<PcKeyword> result = new DataResult<PcKeyword>();
		try {
			List<PcKeyword> list = repository.keywordAll();
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
