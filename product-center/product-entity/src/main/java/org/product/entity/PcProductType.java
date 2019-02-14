package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcProductType extends BaseEntity {

	private static final long serialVersionUID = -4536748682798398322L;

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