package org.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_album_pic")
@ApiModel(value = "相册图集")
public class PcAlbumPic extends BaseEntity {

	private static final long serialVersionUID = -4517833807136641322L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code")
	private String code;

	@ApiModelProperty("图片访问地址")
	@Column(name = "pic_url", insertable = true, nullable = false)
	private String picUrl;
}
