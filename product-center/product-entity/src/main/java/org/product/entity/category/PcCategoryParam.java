package org.product.entity.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcCategoryParam <br>
 * 描述: 分类参数 <br>
 * 作者: zhy<br>
 * 时间: 2019年5月17日 上午9:22:01
 */
@Getter
@Setter
@Entity
@Table(name = "pc_category_param")
public class PcCategoryParam extends FlagEnabledEntity {

	private static final long serialVersionUID = 6934669182849240472L;
	/**
	 * 名称
	 */
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	/**
	 * 排序 正序
	 */
	@Column(name = "sort", nullable = false)
	private Long sort;
}
