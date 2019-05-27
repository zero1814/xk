package org.product.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.product.dto.product.PcProductLabelDto;
import org.product.entity.product.PcProductLabel;
import org.zero.spring.mybatis.BaseMapper;

public interface PcProductLabelMapper extends BaseMapper<PcProductLabel, PcProductLabelDto> {
	int deleteByPrimaryKey(@Param("product") String product, @Param("label") String label);

	PcProductLabel selectByPrimaryKey(@Param("product") String product, @Param("label") String label);

	/**
	 * 
	 * 方法: deleteByProduct <br>
	 * 描述: 根据商品编码删除标签 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月27日 上午9:31:33
	 * 
	 * @param product
	 * @return
	 */
	int deleteByProduct(String product);

	/**
	 * 
	 * 方法: selectByProduct <br>
	 * 描述: 根据商品编码查询标签 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月27日 上午9:31:46
	 * 
	 * @param product
	 * @return
	 */
	List<PcProductLabel> selectByProduct(String product);
}