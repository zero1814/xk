package org.product.entity.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.product.entity.album.PcAlbum;
import org.zero.spring.jpa.BaseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcSku <br>
 * 描述: 商品sku <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:21:26
 */
@Getter
@Setter
@Entity
@Table(name = "pc_sku")
public class PcSku extends BaseEntity {

	private static final long serialVersionUID = -9059563854277341590L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	/**
	 * 主图
	 */
	@Column(name = "main_pic", length = 500, nullable = false, unique = true)
	private String mainPic;

	/**
	 * 成本价
	 */
	@Column(name = "cost_price", nullable = false)
	@JsonProperty("cost_price")
	private BigDecimal costPrice;

	/**
	 * 市场价
	 */
	@Column(name = "market_price", nullable = false)
	@JsonProperty("market_price")
	private BigDecimal marketPrice;

	/**
	 * 销售价
	 */
	@Column(name = "sell_price", nullable = false)
	@JsonProperty("sell_price")
	private BigDecimal sellPrice;

	/**
	 * 相册
	 */
	@OneToOne
	@JoinColumn(name = "album")
	private PcAlbum album;

	/**
	 * 库存
	 */
	@Column(name = "stock", nullable = false)
	private Long stock;

	/**
	 * 预警库存
	 */
	@Column(name = "warn_stock", nullable = false)
	@JsonProperty("warn_stock")
	private Long warnStock;

	/**
	 * 状态
	 */
	@ManyToOne
	@JoinColumn(name = "status")
	private PcSkuStatus status;
}
