package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductDraft;
import org.product.service.product.IPcProdutDraftService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/draft/")
public class PcProdutDraftController extends BaseController<PcProductDraft, IPcProdutDraftService> {

	
}
