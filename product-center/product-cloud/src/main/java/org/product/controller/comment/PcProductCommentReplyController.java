package org.product.controller.comment;

import org.product.controller.BaseController;
import org.product.entity.comment.PcProductCommentReply;
import org.product.service.comment.IPcProductCommentReplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment/reply/")
public class PcProductCommentReplyController
		extends BaseController<PcProductCommentReply, IPcProductCommentReplyService> {

}
