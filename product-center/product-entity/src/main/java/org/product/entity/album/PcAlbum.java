package org.product.entity.album;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcAlbum <br>
 * 描述: 商品中心相册 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:44:19
 */
@Getter
@Setter
@Entity
@Table(name = "pc_album_pics")
public class PcAlbum extends BaseEntity {

	private static final long serialVersionUID = 289119311778403903L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 500, nullable = false)
	private String name;

	/**
	 * 图集总数
	 */
	@Column(name = "total", length = 500, nullable = false)
	private Long total;

}
