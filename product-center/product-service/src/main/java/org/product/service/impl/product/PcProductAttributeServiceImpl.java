package org.product.service.impl.product;

import java.util.List;

import org.product.entity.product.PcProductAttribute;
import org.product.service.product.IPcProductAttributeService;
import org.springframework.stereotype.Service;

import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

@Service
public class PcProductAttributeServiceImpl implements IPcProductAttributeService {

	@Override
	public DataResult<PcProductAttribute> arrange(List<PcProductAttribute> attributes) {
		DataResult<PcProductAttribute> result = new DataResult<PcProductAttribute>();
		try {
			for (PcProductAttribute attribute : attributes) {
				attribute.setCode(CodeHelper.getCode(PcProductAttribute.class));
			}
			result.setCode(ResultType.SUCCESS);
			result.setData(attributes);
			result.setMessage("整理成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("整理失败");
		}
		return result;
	}

}
