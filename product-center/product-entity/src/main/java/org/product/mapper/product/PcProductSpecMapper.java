package org.product.mapper.product;

import org.apache.ibatis.annotations.Param;
import org.product.dto.product.PcProductSpecDto;
import org.product.entity.product.PcProductSpec;
import org.zero.spring.mybatis.BaseMapper;

public interface PcProductSpecMapper extends BaseMapper<PcProductSpec, PcProductSpecDto> {
	int deleteByMap(@Param("product") String product, @Param("specKey") String specKey,
			@Param("specValue") String specValue);

	PcProductSpec selectByMap(@Param("product") String product, @Param("specKey") String specKey,
			@Param("specValue") String specValue);

}