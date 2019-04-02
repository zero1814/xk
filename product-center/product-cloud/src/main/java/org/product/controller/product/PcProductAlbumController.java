package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductAlbum;
import org.product.service.product.IPcProductAlbumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/album/")
public class PcProductAlbumController extends BaseController<PcProductAlbum, IPcProductAlbumService> {

}
