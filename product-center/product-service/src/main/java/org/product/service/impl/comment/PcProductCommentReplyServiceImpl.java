package org.product.service.impl.comment;

import org.product.entity.product.PcProductCommentReply;
import org.product.repository.comment.PcProductCommentReplyRepository;
import org.product.service.comment.IPcProductCommentReplyService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcProductCommentReplyServiceImpl <br>
 * 描述: 商品评价回复业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:18
 */
@Service
public class PcProductCommentReplyServiceImpl
		extends BaseServiceImpl<PcProductCommentReply, String, PcProductCommentReplyRepository>
		implements IPcProductCommentReplyService {

}
