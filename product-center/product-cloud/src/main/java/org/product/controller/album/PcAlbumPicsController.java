package org.product.controller.album;

import org.product.controller.BaseController;
import org.product.entity.album.PcAlbumPics;
import org.product.service.album.IPcAlbumPicsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album/pic/")
public class PcAlbumPicsController extends BaseController<PcAlbumPics, IPcAlbumPicsService> {

}
