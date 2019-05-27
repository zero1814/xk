package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "商品评价表")
public class PcProductComment extends BaseEntity {

	private static final long serialVersionUID = -4653311325842635934L;

	@ApiModelProperty(value = "商品编码")
	private String product;

	@ApiModelProperty(value = "评级")
	private Integer stars;

	@ApiModelProperty(value = "是否已删除 0 未删除 1 已删除")
	private Integer flagDeleted;

}