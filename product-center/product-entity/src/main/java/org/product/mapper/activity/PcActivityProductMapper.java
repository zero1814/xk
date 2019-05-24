package org.product.mapper.activity;

import org.apache.ibatis.annotations.Param;
import org.product.dto.activity.PcActivityProductDto;
import org.product.entity.activity.PcActivityProduct;
import org.zero.spring.mybatis.BaseMapper;

public interface PcActivityProductMapper extends BaseMapper<PcActivityProduct, PcActivityProductDto> {
	int deleteByPrimaryKey(@Param("store") String store, @Param("activity") String activity,
			@Param("product") String product, @Param("sku") String sku);

	PcActivityProduct selectByPrimaryKey(@Param("store") String store, @Param("activity") String activity,
			@Param("product") String product, @Param("sku") String sku);

}