package org.product.entity.product;

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
 * 类: PcProductAlbumPic <br>
 * 描述: 商品相册图片 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月2日 下午4:19:52
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product_album_pic")
public class PcProductAlbumPic extends BaseEntity {

	private static final long serialVersionUID = 7102026692528038336L;

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
}
