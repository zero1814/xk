package org.product.mapper;

import org.product.entity.PcProductPic;

public interface PcProductPicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcProductPic record);

    int insertSelective(PcProductPic record);

    PcProductPic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcProductPic record);

    int updateByPrimaryKey(PcProductPic record);
}