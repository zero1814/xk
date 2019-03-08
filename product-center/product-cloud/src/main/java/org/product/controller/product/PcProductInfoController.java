package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductInfo;
import org.product.result.product.PcProductResult;
import org.product.service.product.IPcProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
public class PcProductInfoController extends BaseController<PcProductInfo, IPcProductInfoService> {

	@Autowired
	private IPcProductInfoService service;

	@GetMapping(value = "init/params")
	public PcProductResult property() {
		return service.initProperties();
	}

}
