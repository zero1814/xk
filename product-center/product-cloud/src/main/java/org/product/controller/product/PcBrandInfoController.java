package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcBrandInfo;
import org.product.service.product.IPcBrandInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand/")
public class PcBrandInfoController extends BaseController<PcBrandInfo, IPcBrandInfoService> {

}
