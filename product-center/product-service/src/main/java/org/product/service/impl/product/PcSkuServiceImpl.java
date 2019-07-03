package org.product.service.impl.product;

import org.product.entity.product.PcSku;
import org.product.repository.product.PcSkuRepository;
import org.product.service.product.IPcSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcSkuServiceImpl <br>
 * 描述: 商品sku业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:51
 */
@Slf4j
@Service
public class PcSkuServiceImpl extends BaseServiceImpl<PcSku, String, PcSkuRepository> implements IPcSkuService {

	@Autowired
	private PcSkuRepository repository;

	@Override
	public EntityResult<PcSku> select(String code) {
		EntityResult<PcSku> result = new EntityResult<PcSku>();
		try {
			PcSku sku = repository.findSku(code);
			if (sku == null) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询对象不存在");
				return result;
			}
			result.setEntity(sku);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), BaseServiceImpl.class);
			result.setCode(ResultType.ERROR);
			result.setMessage("执行查询方法报错，错误原因：\n" + e.getMessage());
			return result;
		}
	}

}
