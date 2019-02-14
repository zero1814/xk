package org.product.mapper;

import org.product.entity.PcProductInfo;

public interface PcProductInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcProductInfo record);

    int insertSelective(PcProductInfo record);

    PcProductInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcProductInfo record);

    int updateByPrimaryKey(PcProductInfo record);
}