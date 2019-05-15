package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductKeywords;
import org.product.service.product.IPcProductKeywordsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/product/keyword/")
@Api(tags = "商品关键字相关")
public class PcProductKeywordsController extends BaseController<PcProductKeywords, IPcProductKeywordsService> {

}
