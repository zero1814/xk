package org.product.entity.category;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 是否可选择 0 唯一 1 单选 2 多选
	 */
	@Column(name = "flag_option")
	private Integer flagOption;

	/**
	 * 录入方式 0 手工录入 1 选择录入
	 */
	@Column(name = "entry_mode")
	private Integer entryMode;

	/**
	 * 是否可以手动新增参数
	 */
	@Column(name = "flag_manual_insert")
	private Integer flagManualInsert;
	/**
	 * 单位
	 */
	@Column(name = "sort", nullable = false)
	private Long sort;
}
