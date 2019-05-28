package org.product.service.impl.label;

import org.product.entity.PcLabel;
import org.product.repository.label.PcLabelRepository;
import org.product.service.label.IPcLabelService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcLabelServiceImpl <br>
 * 描述: 标签业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:47
 */
@Service
public class PcLabelServiceImpl extends BaseServiceImpl<PcLabel, String, PcLabelRepository> implements IPcLabelService {

}
