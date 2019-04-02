package org.product.entity.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcCommentAlbumPic <br>
 * 描述: 评论相册图片 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月2日 下午4:07:44
 */
@Setter
@Getter
@Entity
@Table(name = "pc_comment_album")
public class PcCommentAlbumPic extends BaseEntity {

	private static final long serialVersionUID = 4874507443245150007L;

	/**
	 * 相册编码
	 */
	@ManyToOne
	@JoinColumn(name = "album_code")
	private PcCommentAlbum album;

	/**
	 * 图片访问地址
	 */
	@Column(name = "pic", length = 200, nullable = false)
	private String pic;
}
