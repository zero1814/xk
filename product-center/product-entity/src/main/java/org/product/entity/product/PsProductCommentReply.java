package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "商品评价回复")
public class PsProductCommentReply extends BaseEntity {
	private static final long serialVersionUID = 8467782509178420358L;

	@ApiModelProperty("评价编码")
	private String comment;

	@ApiModelProperty("回复内容")
	private String content;

	@ApiModelProperty(value = "是否已删除 0 未删除 1 已删除")
	private Integer flagDeleted;

}