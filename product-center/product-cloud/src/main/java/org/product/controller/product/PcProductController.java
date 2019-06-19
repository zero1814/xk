package org.product.controller.product;

import org.zero.spring.jpa.BaseController;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductAttribute;
import org.product.entity.product.PcProductSpecification;
import org.product.entity.product.PcSku;
import org.product.service.product.IPcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import zero.commons.basics.result.DataResult;
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

	@GetMapping("specification/{code}")
	public WebResult specification(@PathVariable("code") String code) {
		DataResult<PcProductSpecification> result = service.getSpecification(code);
		return WebResult.data(result);
	}

	@GetMapping("attribute/{code}")
	public WebResult attribute(@PathVariable("code") String code) {
		DataResult<PcProductAttribute> result = service.getAttribute(code);
		return WebResult.data(result);
	}

	@GetMapping("sku/{code}")
	public WebResult sku(@PathVariable("code") String code) {
		DataResult<PcSku> result = service.getSkuList(code);
		return WebResult.data(result);
	}
}
