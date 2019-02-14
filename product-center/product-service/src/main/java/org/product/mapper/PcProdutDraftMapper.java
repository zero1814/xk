package org.product.mapper;

import org.product.entity.PcProdutDraft;

public interface PcProdutDraftMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PcProdutDraft record);

    int insertSelective(PcProdutDraft record);

    PcProdutDraft selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PcProdutDraft record);

    int updateByPrimaryKey(PcProdutDraft record);
}