package org.product.service.impl.product;

import javax.transaction.Transactional;

import org.product.entity.PcAlbum;
import org.product.entity.product.PcProduct;
import org.product.repository.product.PcProductRepository;
import org.product.service.IPcAlbumService;
import org.product.service.product.IPcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcProductServiceImpl <br>
 * 描述: 商品业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:22:18
 */
@Service
public class PcProductServiceImpl extends BaseServiceImpl<PcProduct, String, PcProductRepository>
		implements IPcProductService {
	@Autowired
	private IPcAlbumService albumService;

	@Override
	@Transactional
	public EntityResult<PcProduct> create(PcProduct entity) {
		EntityResult<PcProduct> result = new EntityResult<PcProduct>();
		if (entity.getAlbum() != null) {
			EntityResult<PcAlbum> _result = albumService.create(entity.getAlbum());
			if (_result.getCode() != ResultType.SUCCESS) {
				result.setCode(_result.getCode());
				result.setMessage(_result.getMessage());
				return result;
			}
			entity.setAlbum(_result.getEntity());
		}
		return super.create(entity);
	}

}
