package org.product.controller.category;

import org.product.controller.BaseController;
import org.product.entity.category.PcCategoryAttribute;
import org.product.service.category.IPcCategoryAttributeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category/attribute/")
public class PcCategoryAttributeController extends BaseController<PcCategoryAttribute, IPcCategoryAttributeService> {

}
