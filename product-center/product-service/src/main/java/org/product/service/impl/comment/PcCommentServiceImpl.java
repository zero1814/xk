package org.product.service.impl.comment;

import org.product.entity.comment.PcComment;
import org.product.repository.comment.PcCommentRepository;
import org.product.service.comment.IPcCommentService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcCommentServiceImpl extends BaseServiceImpl<PcComment, String, PcCommentRepository>
		implements IPcCommentService {

}
