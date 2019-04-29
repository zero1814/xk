package org.product.service.impl.comment;

import org.product.entity.comment.PsProductCommentReply;
import org.product.repository.comment.PsProductCommentReplyRepository;
import org.product.service.comment.IPsProductCommentReplyService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PsProductCommentReplyServiceImpl <br>
 * 描述: 商品评价回复业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:18
 */
@Service
public class PsProductCommentReplyServiceImpl
		extends BaseServiceImpl<PsProductCommentReply, String, PsProductCommentReplyRepository>
		implements IPsProductCommentReplyService {

}
