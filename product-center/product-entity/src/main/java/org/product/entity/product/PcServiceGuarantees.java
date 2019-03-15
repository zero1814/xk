package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: PcProductServer <br>
 * 描述: 服务保证 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月14日 下午5:06:07
 */
@Entity
@Table(name = "pc_service_guarantees ")
public class PcServiceGuarantees extends BaseEntity {

	private static final long serialVersionUID = 9181193959002936427L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 是否可用 0 可用 1 不可用
	 */
	@Column(name = "flag_enabled", columnDefinition = "int default 0", nullable = true)
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
