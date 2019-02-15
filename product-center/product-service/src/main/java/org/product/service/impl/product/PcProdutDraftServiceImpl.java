package org.product.service.impl.product;

import org.product.entity.product.PcProdutDraft;
import org.product.repository.product.PcProdutDraftRepository;
import org.product.service.product.IPcProdutDraftService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcProdutDraftServiceImpl extends BaseServiceImpl<PcProdutDraft, String, PcProdutDraftRepository>
		implements IPcProdutDraftService {

}
