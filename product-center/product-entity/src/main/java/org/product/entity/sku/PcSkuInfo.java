package org.product.entity.sku;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.product.entity.product.PcProductInfo;
import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: PcSkuInfo <br>
 * 描述: 商品sku <br>
 * 作者: zhy<br>
 * 时间: 2019年2月15日 上午10:17:19
 */
@Entity
@Table(name = "pc_sku_info")
public class PcSkuInfo extends BaseEntity {

	private static final long serialVersionUID = -7603138016572727953L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_code")
	private PcProductInfo productCode;

	@Column(name = "cost_price", nullable = false)
	private BigDecimal costPrice;

	@Column(name = "sell_price", nullable = false)
	private BigDecimal sellPrice;

	@Column(name = "stock", nullable = false)
	private Long stock;

	@Column(name = "main_pic", nullable = false, length = 200)
	private String mainPic;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type")
	private PcSkuType type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status")
	private PcSkuStatus status;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pc_sku_pic", joinColumns = { @JoinColumn(name = "sku_code") }, inverseJoinColumns = {
			@JoinColumn(name = "code") })
	private List<PcSkuPic> pics;

	public List<PcSkuPic> getPics() {
		return pics;
	}

	public void setPics(List<PcSkuPic> pics) {
		this.pics = pics;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
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

	public String getMainPic() {
		return mainPic;
	}

	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}

	public PcProductInfo getProductCode() {
		return productCode;
	}

	public void setProductCode(PcProductInfo productCode) {
		this.productCode = productCode;
	}

	public PcSkuType getType() {
		return type;
	}

	public void setType(PcSkuType type) {
		this.type = type;
	}

	public PcSkuStatus getStatus() {
		return status;
	}

	public void setStatus(PcSkuStatus status) {
		this.status = status;
	}

}