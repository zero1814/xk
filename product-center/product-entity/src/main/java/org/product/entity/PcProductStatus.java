package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcProductStatus extends BaseEntity {

	private static final long serialVersionUID = -6330335877354066179L;

	private String name;

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