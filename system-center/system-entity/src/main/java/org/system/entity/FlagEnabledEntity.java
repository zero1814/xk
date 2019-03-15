package org.system.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.zero.spring.jpa.BaseEntity;

@MappedSuperclass
public class FlagEnabledEntity extends BaseEntity {

	private static final long serialVersionUID = -8347045613257565292L;
	/**
	 * 是否可用 0 可用 1 不可用
	 */
	@Column(name = "flag_enabled", columnDefinition = "int null default 0")
	private Integer flagEnabled;

	public Integer getFlagEnabled() {
		return flagEnabled;
	}

	public void setFlagEnabled(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

}
