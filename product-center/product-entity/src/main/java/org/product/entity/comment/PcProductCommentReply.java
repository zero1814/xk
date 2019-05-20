package org.product.entity.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ps_product_comment_reply")
@ApiModel(value = "商品回复管理")
public class PcProductCommentReply extends BaseEntity {

	private static final long serialVersionUID = 312898658746706404L;

	@ApiModelProperty("回复内容")
	@Column(name = "content", length = 500, nullable = false)
	private String content;

	/**
	 * 是否已删除 0 未删除 1 已删除
	 */
	@ApiModelProperty("是否已删除 0 未删除 1 已删除")
	@Column(name = "flag_deleted", columnDefinition = "int default 0 ")
	private Integer flagDeleted;
}
