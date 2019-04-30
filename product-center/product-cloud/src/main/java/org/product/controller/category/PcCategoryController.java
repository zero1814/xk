package org.product.controller.category;

import org.product.controller.FlagEnabledController;
import org.product.entity.category.PcCategory;
import org.product.service.category.IPcCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category/")
public class PcCategoryController extends FlagEnabledController<PcCategory, IPcCategoryService>{

}
