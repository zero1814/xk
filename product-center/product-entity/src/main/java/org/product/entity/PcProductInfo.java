package org.product.entity;

import java.math.BigDecimal;

import org.zero.spring.mybatis.BaseEntity;

public class PcProductInfo extends BaseEntity {

	private static final long serialVersionUID = 7284650462326135240L;

	private String storeCode;

	private String name;

	private String enName;

	private String categoryCode;

	private String brandCode;

	private BigDecimal minCostPrice;

	private BigDecimal maxCostPrice;

	private BigDecimal minMarketPrice;

	private BigDecimal maxMarketPrice;

	private BigDecimal minSellPrice;

	private BigDecimal maxSellPrice;

	private String type;

	private String status;

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

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

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public BigDecimal getMinCostPrice() {
		return minCostPrice;
	}

	public void setMinCostPrice(BigDecimal minCostPrice) {
		this.minCostPrice = minCostPrice;
	}

	public BigDecimal getMaxCostPrice() {
		return maxCostPrice;
	}

	public void setMaxCostPrice(BigDecimal maxCostPrice) {
		this.maxCostPrice = maxCostPrice;
	}

	public BigDecimal getMinMarketPrice() {
		return minMarketPrice;
	}

	public void setMinMarketPrice(BigDecimal minMarketPrice) {
		this.minMarketPrice = minMarketPrice;
	}

	public BigDecimal getMaxMarketPrice() {
		return maxMarketPrice;
	}

	public void setMaxMarketPrice(BigDecimal maxMarketPrice) {
		this.maxMarketPrice = maxMarketPrice;
	}

	public BigDecimal getMinSellPrice() {
		return minSellPrice;
	}

	public void setMinSellPrice(BigDecimal minSellPrice) {
		this.minSellPrice = minSellPrice;
	}

	public BigDecimal getMaxSellPrice() {
		return maxSellPrice;
	}

	public void setMaxSellPrice(BigDecimal maxSellPrice) {
		this.maxSellPrice = maxSellPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}