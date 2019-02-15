package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.product.entity.sku.PcSkuInfo;
import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: PcProductStock <br>
 * 描述: 商品库存 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月15日 上午10:11:18
 */
@Entity
@Table(name = "pc_product_stock")
public class PcProductStock extends BaseEntity {

	private static final long serialVersionUID = 875572386031700482L;

	/**
	 * 商品编码
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_code")
	private PcProductInfo productCode;

	/**
	 * sku编码
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sku_code")
	private PcSkuInfo skuCode;

	/**
	 * 修改前库存
	 */
	@Column(name = "before_stock")
	private Long beforeStock;

	/**
	 * 要修改的库存
	 */
	@Column(name = "update_stock")
	private Long updateStock;

	/**
	 * 当前库存
	 */
	@Column(name = "current_stock")
	private Long currentStock;

	public PcProductInfo getProductCode() {
		return productCode;
	}

	public void setProductCode(PcProductInfo productCode) {
		this.productCode = productCode;
	}

	public PcSkuInfo getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(PcSkuInfo skuCode) {
		this.skuCode = skuCode;
	}

	public Long getBeforeStock() {
		return beforeStock;
	}

	public void setBeforeStock(Long beforeStock) {
		this.beforeStock = beforeStock;
	}

	public Long getUpdateStock() {
		return updateStock;
	}

	public void setUpdateStock(Long updateStock) {
		this.updateStock = updateStock;
	}

	public Long getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Long currentStock) {
		this.currentStock = currentStock;
	}

}