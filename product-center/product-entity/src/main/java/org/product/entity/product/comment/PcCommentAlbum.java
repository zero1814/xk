package org.product.entity.product.comment;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcCommentAlbum <br>
 * 描述: 商品评论相册集 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月2日 下午2:40:55
 */
@Setter
@Getter
@Entity
@Table(name = "pc_comment_album")
public class PcCommentAlbum extends BaseEntity {

	private static final long serialVersionUID = -2531463391699341245L;

	/**
	 * 相册封面
	 */
	@Column(name = "cover_pic", length = 200, nullable = false)
	private String coverPic;

	/**
	 * 相册图片总数
	 */
	@Column(name = "total", nullable = false)
	private Long total;

	@OneToMany
	@JoinColumn(name = "album_code")
	private List<PcCommentAlbumPic> pic;
}
