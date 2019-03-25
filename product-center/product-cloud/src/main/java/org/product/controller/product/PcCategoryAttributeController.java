package org.product.controller.product;

import org.product.controller.FlagEnabledController;
import org.product.entity.product.PcCategoryAttribute;
import org.product.service.product.IPcCategoryAttributeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/category/attribute/")
public class PcCategoryAttributeController
		extends FlagEnabledController<PcCategoryAttribute, IPcCategoryAttributeService> {

}
