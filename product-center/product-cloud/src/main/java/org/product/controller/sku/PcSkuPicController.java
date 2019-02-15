package org.product.controller.sku;

import org.product.controller.BaseController;
import org.product.entity.sku.PcSkuPic;
import org.product.service.sku.IPcSkuPicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/sku/pic")
public class PcSkuPicController extends BaseController<PcSkuPic, IPcSkuPicService> {

}
