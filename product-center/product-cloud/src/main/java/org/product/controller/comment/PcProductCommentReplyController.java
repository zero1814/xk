package org.product.controller.comment;

import org.product.controller.BaseController;
import org.product.entity.comment.PcProductCommentReply;
import org.product.service.comment.IPcProductCommentReplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/comment/reply/")
@Api(tags = "商品评论回复相关")
public class PcProductCommentReplyController
		extends BaseController<PcProductCommentReply, IPcProductCommentReplyService> {

}
