package org.product.controller.album;

import org.product.controller.BaseController;
import org.product.entity.album.PcAlbumPics;
import org.product.service.album.IPcAlbumPicsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/album/pic/")
@Api(tags = "商品相册图片相关")
public class PcAlbumPicsController extends BaseController<PcAlbumPics, IPcAlbumPicsService> {

}
