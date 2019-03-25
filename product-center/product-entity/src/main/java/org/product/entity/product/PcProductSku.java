package org.product.entity.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;
/**
 * 
 * 类: PcProductSku <br>
 * 描述: 商品SKU <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:57:12
 */
@Entity
@Table(name = "pc_product_sku")
public class PcProductSku extends BaseEntity {

	private static final long serialVersionUID = 470823651739567059L;

	/**
	 * 商品编码
	 */
	@ManyToOne
	@JoinColumn(name = "product_code")
	private PcProduct product;

	/**
	 * 主图
	 */
	@Column(name = "main_pic", length = 200, nullable = false)
	private String mainPic;

	/**
	 * 成本价
	 */
	@Column(name = "cost_price", nullable = false)
	private BigDecimal costPrice;

	/**
	 * 市场价
	 */
	@Column(name = "market_price", nullable = false)
	private BigDecimal marketPrice;

	/**
	 * 销售价
	 */
	@Column(name = "sell_price", nullable = false)
	private BigDecimal sellPrice;

	/**
	 * 库存
	 */
	@Column(name = "stock", nullable = false)
	private Long stock;

	/**
	 * 预警库存
	 */
	@Column(name = "alarm_stock", nullable = false)
	private Long alarmStock;

	public PcProduct getProduct() {
		return product;
	}

	public void setProduct(PcProduct product) {
		this.product = product;
	}

	public String getMainPic() {
		return mainPic;
	}

	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getAlarmStock() {
		return alarmStock;
	}

	public void setAlarmStock(Long alarmStock) {
		this.alarmStock = alarmStock;
	}

}
