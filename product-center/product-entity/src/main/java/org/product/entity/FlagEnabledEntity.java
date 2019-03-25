package org.product.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.zero.spring.jpa.BaseEntity;

@MappedSuperclass
public class FlagEnabledEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "flag_enabled", columnDefinition = "int default 0")
	private int flagEnabled;

	public int getFlagEnabled() {
		return flagEnabled;
	}

	public void setFlagEnabled(int flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

}
