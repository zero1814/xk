package org.product.entity.category;

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
@Table(name = "pc_category_attribute")
@ApiModel(value = "商品分类属性管理")
public class PcCategoryAttribute extends BaseEntity {

	private static final long serialVersionUID = 3334564301410737003L;

	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 是否可选择 0 唯一 1 单选 2 多选
	 */
	@ApiModelProperty("是否可选择 0 唯一 1 单选 2 多选")
	@Column(name = "flag_option")
	private Integer flagOption;

	/**
	 * 录入方式 0 手工录入 1 选择录入
	 */
	@ApiModelProperty("录入方式 0 手工录入 1 选择录入")
	@Column(name = "entry_mode")
	private Integer entryMode;

	/**
	 * 是否可以手动新增参数
	 */
	@ApiModelProperty("是否可以手动新增参数 0 可以 1 不可以")
	@Column(name = "flag_manual_insert")
	private Integer flagManualInsert;
	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
	@Column(name = "sort", nullable = false)
	private Long sort;
}
