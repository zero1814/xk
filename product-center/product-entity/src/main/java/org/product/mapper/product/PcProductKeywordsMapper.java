package org.product.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.product.dto.product.PcProductKeywordsDto;
import org.product.entity.product.PcProductKeywords;
import org.zero.spring.mybatis.BaseMapper;

public interface PcProductKeywordsMapper extends BaseMapper<PcProductKeywords, PcProductKeywordsDto> {
	int deleteByPrimaryKey(@Param("product") String product, @Param("keywords") String keywords);

	PcProductKeywords selectByPrimaryKey(@Param("product") String product, @Param("keywords") String keywords);

	/**
	 * 
	 * 方法: selectByProduct <br>
	 * 描述: 根据商品编码查询关键字 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月27日 上午9:30:13
	 * 
	 * @param product
	 * @return
	 */
	List<PcProductKeywords> selectByProduct(String product);

	/**
	 * 
	 * 方法: deleteByProduct <br>
	 * 描述: 根据商品编码删除关键字 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月27日 上午9:30:27
	 * 
	 * @param product
	 * @return
	 */
	int deleteByProduct(String product);
}