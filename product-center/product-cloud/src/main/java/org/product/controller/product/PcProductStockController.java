package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcProductStock;
import org.product.service.product.IPcProductStockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/stock/")
public class PcProductStockController extends BaseController<PcProductStock, IPcProductStockService>{

}
