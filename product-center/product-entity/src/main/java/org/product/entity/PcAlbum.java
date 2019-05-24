package org.product.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "相册")
public class PcAlbum extends BaseEntity {

	private static final long serialVersionUID = -1507858176676400988L;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "相片总数")
	private Long total;

}