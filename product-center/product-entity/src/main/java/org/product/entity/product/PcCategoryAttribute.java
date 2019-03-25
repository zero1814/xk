package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

@Entity
@Table(name = "pc_category_attribute")
public class PcCategoryAttribute extends FlagEnabledEntity {

	private static final long serialVersionUID = -8634906666227346860L;

	/**
	 * 分类编码
	 */
	@ManyToOne
	@JoinColumn(name = "category_code")
	private PcCategory categoryCode;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	/**
	 * 排序
	 */
	@Column(name = "sort", columnDefinition = "int default 0")
	private int sort;

	public PcCategory getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(PcCategory categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
