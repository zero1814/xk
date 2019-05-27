package org.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@ApiModelProperty("图片访问地址")
	@Column(name = "pic_url", insertable = true, nullable = false)
	private String picUrl;

	@ApiModelProperty("创建时间")
	@Column(name = "create_time", insertable = true, updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
}
