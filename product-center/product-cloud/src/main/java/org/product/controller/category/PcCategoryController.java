package org.product.controller.category;

import org.product.controller.FlagEnabledController;
import org.product.entity.category.PcCategory;
import org.product.service.category.IPcCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/category/")
@Api(tags = "商品分类相关")
public class PcCategoryController extends FlagEnabledController<PcCategory, IPcCategoryService>{

}
