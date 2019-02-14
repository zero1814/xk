package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcProdutDraft extends BaseEntity {

	private static final long serialVersionUID = 7082083721940584490L;

	private String name;

	private String enName;

	private String data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}