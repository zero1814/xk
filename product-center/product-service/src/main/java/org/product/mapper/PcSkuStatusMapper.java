package org.product.mapper;

import org.product.entity.PcSkuStatus;

public interface PcSkuStatusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcSkuStatus record);

    int insertSelective(PcSkuStatus record);

    PcSkuStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcSkuStatus record);

    int updateByPrimaryKey(PcSkuStatus record);
}