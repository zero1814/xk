package org.product.service.impl;

import org.product.entity.PcBrand;
import org.product.repository.PcBrandRepository;
import org.product.service.IPcBrandService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcBrandServiceImpl <br>
 * 描述: 品牌业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:23:43
 */
@Service
public class PcBrandServiceImpl extends BaseServiceImpl<PcBrand, String, PcBrandRepository> implements IPcBrandService {

}
