package org.product.controller.comment;

import org.zero.spring.jpa.BaseController;
import org.product.entity.product.PcProductComment;
import org.product.service.comment.IPcProductCommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/comment/")
@Api(tags = "商品评论相关")
public class PcProductCommentController extends BaseController<PcProductComment, IPcProductCommentService> {

}
