package org.product.controller.comment;

import org.product.controller.BaseController;
import org.product.entity.comment.PsProductComment;
import org.product.service.comment.IPsProductCommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment/")
public class PsProductCommentController extends BaseController<PsProductComment, IPsProductCommentService> {

}
