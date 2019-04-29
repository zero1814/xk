package org.product.service.impl.comment;

import org.product.entity.comment.PsProductComment;
import org.product.repository.comment.PsProductCommentRepository;
import org.product.service.comment.IPsProductCommentService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

/**
 * 
 * 类: PsProductCommentServiceImpl <br>
 * 描述: 商品评价业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:34
 */
@Service
public class PsProductCommentServiceImpl extends BaseServiceImpl<PsProductComment, String, PsProductCommentRepository>
		implements IPsProductCommentService {

}
