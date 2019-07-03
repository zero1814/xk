package org.product.service.impl.comment;

import org.product.entity.product.PcProductComment;
import org.product.repository.comment.PcProductCommentRepository;
import org.product.service.comment.IPcProductCommentService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PcProductCommentServiceImpl <br>
 * 描述: 商品评价业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:34
 */
@Service
public class PcProductCommentServiceImpl extends BaseServiceImpl<PcProductComment, String, PcProductCommentRepository>
		implements IPcProductCommentService {

}
