package org.product.controller;

import org.product.entity.PcKeywords;
import org.product.service.IPcKeywordsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keyword/")
public class PcKeywordsController extends BaseController<PcKeywords, IPcKeywordsService> {

}
