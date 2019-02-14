package org.product.mapper;

import org.product.entity.PcCategory;

public interface PcCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcCategory record);

    int insertSelective(PcCategory record);

    PcCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcCategory record);

    int updateByPrimaryKey(PcCategory record);
}