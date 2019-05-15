package org.product.controller.category;

import org.product.controller.BaseController;
import org.product.entity.category.PcCategoryAttribute;
import org.product.service.category.IPcCategoryAttributeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/category/attribute/")
@Api(tags = "商品分类属性相关")
public class PcCategoryAttributeController extends BaseController<PcCategoryAttribute, IPcCategoryAttributeService> {

}
