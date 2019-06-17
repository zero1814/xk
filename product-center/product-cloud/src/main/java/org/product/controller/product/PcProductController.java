package org.product.controller.product;

import org.zero.spring.jpa.BaseController;
import org.product.entity.product.PcProduct;
import org.product.service.product.IPcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/product/")
@Api(tags = "商品相关")
public class PcProductController extends BaseController<PcProduct, IPcProductService> {

	@Autowired
	private IPcProductService service;

	@GetMapping("get/{code}")
	public WebResult select(@PathVariable("code") String code) {
		EntityResult<PcProduct> result = service.getProduct(code);
		return WebResult.obj(result);
	}

}
