package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcSkuType extends BaseEntity {

	private static final long serialVersionUID = -5805367183525249913L;

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