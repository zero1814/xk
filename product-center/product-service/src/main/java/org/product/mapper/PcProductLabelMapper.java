package org.product.mapper;

import org.product.entity.PcProductLabel;

public interface PcProductLabelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcProductLabel record);

    int insertSelective(PcProductLabel record);

    PcProductLabel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcProductLabel record);

    int updateByPrimaryKey(PcProductLabel record);
}