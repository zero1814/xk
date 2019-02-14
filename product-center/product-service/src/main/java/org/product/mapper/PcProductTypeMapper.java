package org.product.mapper;

import org.product.entity.PcProductType;

public interface PcProductTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcProductType record);

    int insertSelective(PcProductType record);

    PcProductType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcProductType record);

    int updateByPrimaryKey(PcProductType record);
}