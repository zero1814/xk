package org.product.mapper;

import org.product.entity.PcSkuType;

public interface PcSkuTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcSkuType record);

    int insertSelective(PcSkuType record);

    PcSkuType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcSkuType record);

    int updateByPrimaryKey(PcSkuType record);
}