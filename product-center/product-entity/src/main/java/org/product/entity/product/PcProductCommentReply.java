package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "商品评价回复表")
public class PcProductCommentReply extends BaseEntity {

	private static final long serialVersionUID = 8908416241441038547L;

	@ApiModelProperty(value = "商品评价编码")
	private String comment;

	@ApiModelProperty(value = "回复内容")
	private String content;

	@ApiModelProperty(value = "是否已删除 0 未删除 1 已删除")
	private Integer flagDeleted;

}