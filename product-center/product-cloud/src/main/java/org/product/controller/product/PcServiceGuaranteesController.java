package org.product.controller.product;

import org.product.controller.BaseController;
import org.product.entity.product.PcServiceGuarantees;
import org.product.service.product.IPcServiceGuaranteesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 类: PcServiceGuaranteesController <br>
 * 描述: 商品服务保证对外接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月14日 下午5:12:05
 */
@RestController
@RequestMapping("/product/service_guarantees/")
public class PcServiceGuaranteesController extends BaseController<PcServiceGuarantees, IPcServiceGuaranteesService> {

}
