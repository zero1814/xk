package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductPic;
import org.product.service.product.IPcProductPicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/pic/")
public class PcProductPicController extends BaseController<PcProductPic, IPcProductPicService> {

}
