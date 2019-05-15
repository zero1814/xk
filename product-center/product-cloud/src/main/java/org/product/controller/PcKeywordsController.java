package org.product.controller;

import org.product.entity.PcKeywords;
import org.product.service.IPcKeywordsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/keyword/")
@Api(tags = "关键字相关")
public class PcKeywordsController extends BaseController<PcKeywords, IPcKeywordsService> {

}
