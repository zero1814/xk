package org.product.service.impl.label;

import org.product.entity.product.PcLabel;
import org.product.repository.label.PcLabelRepository;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.product.service.label.IPcLabelService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PcLabelServiceImpl <br>
 * 描述: 标签业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:47
 */
@Service
public class PcLabelServiceImpl extends FlagEnabledServiceImpl<PcLabel, String, PcLabelRepository> implements IPcLabelService {

}
