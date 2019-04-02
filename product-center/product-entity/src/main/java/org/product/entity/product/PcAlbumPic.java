package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_album_pic")
public class PcAlbumPic extends BaseEntity {

	private static final long serialVersionUID = 2564255608368693139L;

	/**
	 * 相册编码
	 */
	@ManyToOne
	@JoinColumn(name = "album_code")
	private PcProductAlbum album;

	/**
	 * 图片访问地址
	 */
	@Column(name = "pic", length = 200, nullable = false)
	private String pic;

	/**
	 * 排序
	 */
	@Column(name = "sort", columnDefinition = "bigint default 0")
	private Long sort;
}
