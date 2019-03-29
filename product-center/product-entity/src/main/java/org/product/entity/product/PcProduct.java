package org.product.entity.product;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.product.entity.store.PcStore;
import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcProduct <br>
 * 描述: 商品表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:51:22
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product")
public class PcProduct extends BaseEntity {

	private static final long serialVersionUID = 2020024308002419954L;

	/**
	 * 主图
	 */
	@Column(name = "main_pic", length = 200, nullable = false)
	private String mainPic;

	/**
	 * 品牌
	 */
	@ManyToOne
	@JoinColumn(name = "brand")
	private PcBrand brand;

	/**
	 * 店铺
	 */
	@ManyToOne
	@JoinColumn(name = "store")
	private PcStore store;

	/**
	 * 最小销售价
	 */
	@Column(name = "min_sell_price", nullable = false)
	private BigDecimal minSellPrice;

	/**
	 * 最大销售价
	 */
	@Column(name = "max_sell_price", nullable = false)
	private BigDecimal maxSellPrice;

	/**
	 * 状态
	 */
	@ManyToOne
	@JoinColumn(name = "status")
	private PcProductStatus status;

	/**
	 * 商品标签
	 */
	@OneToMany
	@JoinTable(name = "pc_product_label", joinColumns = { @JoinColumn(name = "product_code") }, inverseJoinColumns = {
			@JoinColumn(name = "label_code") })
	private List<PcLabel> labels;

	/**
	 * 商品SKU列表
	 */
	@OneToMany
	@JoinColumn(name = "product_code")
	private List<PcProductSku> sku;

	/**
	 * 商品相册
	 */
	@OneToMany
	@JoinColumn(name = "product_code")
	private List<PcProductAlbum> album;
}
