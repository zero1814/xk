package org.product.service.impl.album;

import org.product.entity.album.PcAlbumPics;
import org.product.repository.album.PcAlbumPicsRepository;
import org.product.service.album.IPcAlbumPicsService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcAlbumPicsServiceImpl <br>
 * 描述: 相册图集业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:20:30
 */
@Service
public class PcAlbumPicsServiceImpl extends BaseServiceImpl<PcAlbumPics, String, PcAlbumPicsRepository>
		implements IPcAlbumPicsService {

}
