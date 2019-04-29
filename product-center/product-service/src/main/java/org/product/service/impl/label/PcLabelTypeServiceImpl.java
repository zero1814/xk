package org.product.service.impl.label;

import org.product.entity.label.PcLabelType;
import org.product.repository.label.PcLabelTypeRepository;
import org.product.service.label.IPcLabelTypeService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcLabelTypeServiceImpl <br>
 * 描述: 标签类型业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:56
 */
@Service
public class PcLabelTypeServiceImpl extends BaseServiceImpl<PcLabelType, String, PcLabelTypeRepository>
		implements IPcLabelTypeService {

}
