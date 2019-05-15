package org.product.entity.album;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcAlbumPics <br>
 * 描述: 相册图集 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:42:59
 */
@Getter
@Setter
@Entity
@Table(name = "pc_album_pics")
public class PcAlbumPics extends BaseEntity {

	private static final long serialVersionUID = -5537534091981158285L;

	/**
	 * 图片访问地址
	 */
	@Column(name = "pic_url", length = 500, nullable = false)
	private String picUrl;
}
