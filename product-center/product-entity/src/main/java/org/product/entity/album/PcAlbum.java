package org.product.entity.album;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "pc_album")
@ApiModel("相册管理")
public class PcAlbum extends BaseEntity {

	private static final long serialVersionUID = 289119311778403903L;

	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	@Column(name = "name", length = 500, nullable = false,unique=true)
	private String name;

	/**
	 * 图集总数
	 */
	@ApiModelProperty("图集总数")
	@Column(name = "total", length = 500, nullable = false)
	private Long total;

	/**
	 * 相册图集列表
	 */
	@ApiModelProperty("相册图集列表")
	@OneToMany
	@JoinColumn(name = "album")
	private List<PcAlbumPics> pics;

}
