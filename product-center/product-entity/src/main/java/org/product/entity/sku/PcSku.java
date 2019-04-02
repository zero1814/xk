package org.product.entity.sku;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.product.entity.product.PcProduct;
import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcProductSku <br>
 * 描述: 商品SKU <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:57:12
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product_sku")
public class PcSku extends BaseEntity {

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

	/**
	 * sku相册集
	 */
	@OneToOne
	@JoinColumn(name = "album")
	private PcSkuAlbum album;
}
