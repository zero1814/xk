package org.product.service.impl.sku;

import org.product.entity.sku.PcSkuAlbum;
import org.product.repository.sku.PcSkuAlbumRepository;
import org.product.service.sku.IPcSkuAlbumService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcSkuAlbumServiceImpl extends BaseServiceImpl<PcSkuAlbum, String, PcSkuAlbumRepository>
		implements IPcSkuAlbumService {

}
