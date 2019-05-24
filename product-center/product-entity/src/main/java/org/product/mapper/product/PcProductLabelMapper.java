package org.product.mapper.product;

import org.apache.ibatis.annotations.Param;
import org.product.dto.product.PcProductLabelDto;
import org.product.entity.product.PcProductLabel;
import org.zero.spring.mybatis.BaseMapper;

public interface PcProductLabelMapper extends BaseMapper<PcProductLabel, PcProductLabelDto> {
	int deleteByPrimaryKey(@Param("product") String product, @Param("label") String label);

	PcProductLabel selectByPrimaryKey(@Param("product") String product, @Param("label") String label);
}