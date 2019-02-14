package org.product.mapper;

import org.product.entity.PcProductStatus;

public interface PcProductStatusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcProductStatus record);

    int insertSelective(PcProductStatus record);

    PcProductStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcProductStatus record);

    int updateByPrimaryKey(PcProductStatus record);
}