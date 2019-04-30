package org.product.controller.comment;

import org.product.controller.BaseController;
import org.product.entity.comment.PcProductComment;
import org.product.service.comment.IPcProductCommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment/")
public class PcProductCommentController extends BaseController<PcProductComment, IPcProductCommentService> {

}
