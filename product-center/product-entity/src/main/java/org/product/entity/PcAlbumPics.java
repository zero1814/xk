package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="相册图片")
public class PcAlbumPics extends BaseEntity {

	private static final long serialVersionUID = 5684374525177517151L;
	
	@ApiModelProperty(value = "图片链接地址")
	private String picUrl;
}