package org.product.mapper;

import org.product.entity.PcLabel;

public interface PcLabelMapper {
    int deleteByPrimaryKey(String id);

    int insert(PcLabel record);

    int insertSelective(PcLabel record);

    PcLabel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PcLabel record);

    int updateByPrimaryKey(PcLabel record);
}