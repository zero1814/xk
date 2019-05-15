package org.product.entity.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_category_attribute")
public class PcCategoryAttribute extends BaseEntity {

	private static final long serialVersionUID = 3334564301410737003L;

	/**
	 * 分类编码
	 */
	@ManyToOne
	@JoinColumn(name = "category")
	private PcCategory category;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 单位
	 */
	@Column(name = "unit", length = 50, nullable = true)
	private String unit;
	@Column(name = "sort", nullable = false)
	private Long sort;
}
