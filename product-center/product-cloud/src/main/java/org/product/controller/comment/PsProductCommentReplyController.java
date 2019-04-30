package org.product.controller.comment;

import org.product.controller.BaseController;
import org.product.entity.comment.PsProductCommentReply;
import org.product.service.comment.IPsProductCommentReplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment/reply/")
public class PsProductCommentReplyController
		extends BaseController<PsProductCommentReply, IPsProductCommentReplyService> {

}
