package org.product.controller.product;

import org.product.controller.FlagEnabledController;
import org.product.entity.product.PcCategory;
import org.product.service.product.IPcCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/category/")
public class PcCategoryController extends FlagEnabledController<PcCategory, IPcCategoryService>{

}
