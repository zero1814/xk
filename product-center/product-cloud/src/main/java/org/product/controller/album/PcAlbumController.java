package org.product.controller.album;

import org.product.controller.BaseController;
import org.product.entity.album.PcAlbum;
import org.product.service.album.IPcAlbumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album/")
public class PcAlbumController extends BaseController<PcAlbum, IPcAlbumService> {

}
