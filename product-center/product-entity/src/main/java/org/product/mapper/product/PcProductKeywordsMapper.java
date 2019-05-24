package org.product.mapper.product;

import org.apache.ibatis.annotations.Param;
import org.product.dto.product.PcProductKeywordsDto;
import org.product.entity.product.PcProductKeywords;
import org.zero.spring.mybatis.BaseMapper;

public interface PcProductKeywordsMapper extends BaseMapper<PcProductKeywords, PcProductKeywordsDto> {
	int deleteByPrimaryKey(@Param("product") String product, @Param("keywords") String keywords);

	PcProductKeywords selectByPrimaryKey(@Param("product") String product, @Param("keywords") String keywords);
}