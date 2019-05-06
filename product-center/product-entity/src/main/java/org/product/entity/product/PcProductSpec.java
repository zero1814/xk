package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_activity_spec")
public class PcProductSpec extends BaseEntity {

	private static final long serialVersionUID = -3315204042315937888L;

	@ManyToOne
	@JoinColumn(name = "product")
	private PcProduct product;

	@Column(name = "key", length = 50, nullable = false, unique = true)
	@NotNull(message = "规格名称不能为空")
	private String key;
	@Column(name = "value", length = 500, nullable = false)
	@NotNull(message = "规格参数值不能为空")
	private String value;
	@Column(name = "sort", nullable = false)
	private Long sort;

}
