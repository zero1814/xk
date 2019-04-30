package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductKeywords;
import org.product.service.product.IPcProductKeywordsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/keyword/")
public class PcProductKeywordsController extends BaseController<PcProductKeywords, IPcProductKeywordsService> {

}
