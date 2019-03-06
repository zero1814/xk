package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: PcCategory <br>
 * 描述: 商品分类 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月15日 上午9:48:46
 */
@Entity
@Table(name = "pc_category")
public class PcCategory extends BaseEntity {

	private static final long serialVersionUID = -316067999397194462L;

	public PcCategory() {

	}

	public PcCategory(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 是否可用 0 可用 1 不可用
	 */
	@Column(name = "flag_enabled", columnDefinition = "int default 0")
	private Integer flagEnabled;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFlagEnabled() {
		return flagEnabled;
	}

	public void setFlagEnabled(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

}