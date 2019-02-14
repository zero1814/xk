package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcBrandInfo extends BaseEntity {

	private static final long serialVersionUID = 8328486928128907182L;

	private String name;

	private String enName;

	private String picUrl;

	private Integer flagEnabled;

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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getFlagEnabled() {
		return flagEnabled;
	}

	public void setFlagEnabled(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

}