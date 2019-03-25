package org.product.service.impl.product;

import org.product.entity.product.PcProductAlbum;
import org.product.repository.product.PcProductAlbumRepository;
import org.product.service.product.IPcProductAlbumService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProductAlbumServiceImpl extends BaseServiceImpl<PcProductAlbum, String, PcProductAlbumRepository>
		implements IPcProductAlbumService {

}
