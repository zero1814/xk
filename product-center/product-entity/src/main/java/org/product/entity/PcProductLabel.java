package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcProductLabel extends BaseEntity {

	private static final long serialVersionUID = -904280583593900212L;

	private String productCode;

	private String labelCode;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getLabelCode() {
		return labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}

}