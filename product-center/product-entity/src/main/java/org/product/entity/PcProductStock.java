package org.product.entity;

import org.zero.spring.mybatis.BaseEntity;

public class PcProductStock extends BaseEntity {

	private static final long serialVersionUID = 875572386031700482L;

	private String productCode;

	private String skuCode;

	private String beforeStock;

	private String updateStock;

	private String currentStock;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getBeforeStock() {
		return beforeStock;
	}

	public void setBeforeStock(String beforeStock) {
		this.beforeStock = beforeStock;
	}

	public String getUpdateStock() {
		return updateStock;
	}

	public void setUpdateStock(String updateStock) {
		this.updateStock = updateStock;
	}

	public String getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(String currentStock) {
		this.currentStock = currentStock;
	}

}