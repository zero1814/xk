package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcCategory;
import org.product.service.product.IPcCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category/")
public class PcCategoryController extends BaseController<PcCategory, IPcCategoryService>{

}
