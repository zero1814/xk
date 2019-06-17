package org.product.controller.product;

import java.util.List;

import org.product.entity.product.PcProductAttribute;
import org.product.service.product.IPcProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import zero.commons.basics.result.WebResult;

@RestController
@RequestMapping("/product/attribute/")
@Api(tags = "商品属性相关")
public class PcProductAttributeController {

	@Autowired
	private IPcProductAttributeService service;

	@PostMapping
	public WebResult arrange(@RequestBody List<PcProductAttribute> attributes) {
		return WebResult.data(service.arrange(attributes));
	}
}
