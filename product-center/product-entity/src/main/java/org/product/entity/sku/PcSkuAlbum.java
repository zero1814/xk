package org.product.entity.sku;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_sku_album")
public class PcSkuAlbum extends BaseEntity {

	private static final long serialVersionUID = -3349202310001814617L;

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

	/**
	 * 相册图片集
	 */
	@OneToMany
	@JoinColumn(name = "album_code")
	private List<PcSkuAlbumPic> pic;
}
