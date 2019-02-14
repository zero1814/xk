package org.product.mapper;

import org.product.entity.PcSkuInfo;

public interface PcSkuInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcSkuInfo record);

    int insertSelective(PcSkuInfo record);

    PcSkuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcSkuInfo record);

    int updateByPrimaryKey(PcSkuInfo record);
}