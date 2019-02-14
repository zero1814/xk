package org.product.mapper;

import org.product.entity.PcProductStock;

public interface PcProductStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcProductStock record);

    int insertSelective(PcProductStock record);

    PcProductStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcProductStock record);

    int updateByPrimaryKey(PcProductStock record);
}