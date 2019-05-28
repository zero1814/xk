package org.product.service.impl;

import org.product.entity.PcAlbum;
import org.product.repository.PcAlbumRepository;
import org.product.service.IPcAlbumService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcAlbumServiceImpl <br>
 * 描述: 相册业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:20:52
 */
@Service
public class PcAlbumServiceImpl extends BaseServiceImpl<PcAlbum, String, PcAlbumRepository> implements IPcAlbumService {

}