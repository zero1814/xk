package org.product.mapper.sku;

import java.util.List;

import org.product.dto.sku.PcSkuDto;
import org.product.entity.sku.PcSku;
import org.zero.spring.mybatis.BaseMapper;

public interface PcSkuMapper extends BaseMapper<PcSku, PcSkuDto> {

	/**
	 * 
	 * 方法: selectByProduct <br>
	 * 描述: 根据商品编码查询sku列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月27日 上午10:01:52
	 * 
	 * @param product
	 * @return
	 */
	List<PcSku> selectByProduct(String product);
}