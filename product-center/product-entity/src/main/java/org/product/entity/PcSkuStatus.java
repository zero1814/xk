package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcSkuStatus extends BaseEntity {

	private static final long serialVersionUID = 2085517132846565461L;

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