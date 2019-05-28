package org.product.controller.album;

import org.product.entity.PcAlbum;
import org.product.service.IPcAlbumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zero.spring.jpa.BaseController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/album/")
@Api(tags = "商品相册相关")
public class PcAlbumController extends BaseController<PcAlbum, IPcAlbumService> {

}
