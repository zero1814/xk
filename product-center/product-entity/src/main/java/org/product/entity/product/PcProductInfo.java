package org.product.entity.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

@Entity
@Table(name = "pc_product_info")
public class PcProductInfo extends BaseEntity {

	private static final long serialVersionUID = 7284650462326135240L;

	/**
	 * 店铺编码
	 */
	@Column(name = "store_code", length = 50, nullable = false)
	private String storeCode;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 英文名称
	 */
	@Column(name = "en_name", length = 50, nullable = false)
	private String enName;

	/**
	 * 分类编码
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_code")
	private PcCategory category;

	/**
	 * 品牌编码
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_code")
	private PcBrandInfo brandCode;

	@Column(name = "min_cost_price", nullable = false)
	private BigDecimal minCostPrice;

	@Column(name = "max_cost_price", nullable = false)
	private BigDecimal maxCostPrice;

	@Column(name = "min_market_price", nullable = false)
	private BigDecimal minMarketPrice;

	@Column(name = "max_market_price", nullable = false)
	private BigDecimal maxMarketPrice;

	@Column(name = "min_sell_price", nullable = false)
	private BigDecimal minSellPrice;

	@Column(name = "max_sell_price", nullable = false)
	private BigDecimal maxSellPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type")
	private PcProductType type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status")
	private PcProductStatus status;

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

	public PcCategory getCategory() {
		return category;
	}

	public void setCategory(PcCategory category) {
		this.category = category;
	}

	public PcBrandInfo getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(PcBrandInfo brandCode) {
		this.brandCode = brandCode;
	}

	public PcProductType getType() {
		return type;
	}

	public void setType(PcProductType type) {
		this.type = type;
	}

	public PcProductStatus getStatus() {
		return status;
	}

	public void setStatus(PcProductStatus status) {
		this.status = status;
	}

}