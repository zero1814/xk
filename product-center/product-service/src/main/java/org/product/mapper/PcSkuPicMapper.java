package org.product.mapper;

import org.product.entity.PcSkuPic;

public interface PcSkuPicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcSkuPic record);

    int insertSelective(PcSkuPic record);

    PcSkuPic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcSkuPic record);

    int updateByPrimaryKey(PcSkuPic record);
}