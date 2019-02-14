package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcCategory extends BaseEntity {

	private static final long serialVersionUID = -316067999397194462L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}