package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcSkuPic extends BaseEntity {

	private static final long serialVersionUID = 4226790008540386566L;

	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}