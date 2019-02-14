package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcProductPic extends BaseEntity {

	private static final long serialVersionUID = -5273692513783580263L;

	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}