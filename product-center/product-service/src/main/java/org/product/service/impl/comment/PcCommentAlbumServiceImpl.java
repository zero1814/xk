package org.product.service.impl.comment;

import org.product.entity.comment.PcCommentAlbum;
import org.product.repository.comment.PcCommentAlbumRepository;
import org.product.service.comment.IPcCommentAlbumService;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;

@Service
public class PcCommentAlbumServiceImpl extends BaseServiceImpl<PcCommentAlbum, String, PcCommentAlbumRepository>
		implements IPcCommentAlbumService {

}
