package org.product.service.impl.product;

import org.product.entity.product.PcProductDraft;
import org.product.repository.product.PcProdutDraftRepository;
import org.product.service.product.IPcProdutDraftService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProdutDraftServiceImpl extends BaseServiceImpl<PcProductDraft, String, PcProdutDraftRepository>
		implements IPcProdutDraftService {

}
