package org.product.entity.product;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.product.entity.PcBrand;
import org.product.entity.album.PcAlbum;
import org.product.entity.comment.PcProductComment;
import org.product.entity.label.PcLabel;
import org.zero.spring.jpa.BaseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcProduct <br>
 * 描述: 商品 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:09:01
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product")
public class PcProduct extends BaseEntity {

	private static final long serialVersionUID = 7234968266790089305L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	/**
	 * 英文名称
	 */
	@Column(name = "en_name", length = 50, nullable = false, unique = true)
	@JsonProperty(value = "en_name")
	private String enName;

	/**
	 * 主图
	 */
	@Column(name = "main_pic", length = 500, nullable = false, unique = true)
	@JsonProperty(value = "main_pic")
	private String mainPic;

	/**
	 * 相册
	 */
	@OneToOne
	@JoinColumn(name = "album")
	private PcAlbum album;

	/**
	 * 品牌
	 */
	@ManyToOne
	@JoinColumn(name = "brand")
	private PcBrand brand;

	/**
	 * 最低销售价
	 */
	@Column(name = "min_sell_price", nullable = false)
	private BigDecimal minSellPrice;

	/**
	 * 最高销售价
	 */
	@Column(name = "max_sell_price", nullable = false)
	private BigDecimal maxSellPrice;

	/**
	 * 类型
	 */
	@ManyToOne
	@JoinColumn(name = "type")
	private PcProductType type;
	/**
	 * 状态
	 */
	@ManyToOne
	@JoinColumn(name = "status")
	private PcProductStatus status;

	/**
	 * 排序
	 */
	@Column(name = "sort", nullable = false)
	private Long sort;

	/**
	 * 商品标签
	 */
	@OneToMany
	@JoinTable(name = "pc_product_label", joinColumns = { @JoinColumn(name = "product") }, inverseJoinColumns = {
			@JoinColumn(name = "label") })
	private List<PcLabel> labels;

	/**
	 * 商品评价
	 */
	@OneToMany
	@JoinColumn(name = "product")
	private List<PcProductComment> comments;

	/**
	 * 商品关键字
	 */
	@OneToMany
	@JoinColumn(name = "product")
	private List<PcProductKeywords> keywords;

	/**
	 * 商品规格
	 */
	@OneToMany
	@JoinColumn(name = "product")
	private List<PcProductSpec> spec;

	@OneToMany
	@JoinColumn(name = "product")
	private List<PcSku> skuList;
}
