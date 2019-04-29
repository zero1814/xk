package org.product.entity.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.product.entity.product.PcProduct;
import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ps_product_comment")
public class PsProductComment extends BaseEntity {

	private static final long serialVersionUID = 3085737393297633529L;

	@ManyToOne
	@JoinColumn(name = "product")
	private PcProduct product;

	@Column(name = "content", length = 500, nullable = false)
	private String content;

	@Column(name = "starts", nullable = false)
	private Integer starts;

	/**
	 * 是否已删除 0 未删除 1 已删除
	 */
	@Column(name = "flag_deleted", columnDefinition = "int default 0 ")
	private Integer flagDeleted;

}
