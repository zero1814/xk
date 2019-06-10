package org.product.entity.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.product.entity.PcAlbum;
import org.product.entity.PcBrand;
import org.product.entity.PcKeyword;
import org.product.entity.PcLabel;
import org.product.entity.category.PcCategory;
import org.product.entity.store.PcStore;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_product")
@ApiModel(value = "商品管理")
public class PcProduct extends BaseEntity {

	private static final long serialVersionUID = 8874070647969533827L;

	public PcProduct() {

	}

	public PcProduct(String code, String name, String enName, String mainPic, PcStore store, PcBrand brand,
			PcCategory category, BigDecimal minSellPrice, BigDecimal maxSellPrice, PcProductStatus status,
			Integer sort) {
		this.code = code;
		this.name = name;
		this.enName = enName;
		this.mainPic = mainPic;
		this.store = store;
		this.brand = brand;
		this.category = category;
		this.minSellPrice = minSellPrice;
		this.maxSellPrice = maxSellPrice;
		this.status = status;
		this.sort = sort;
	}

	public PcProduct(List<PcSku> skuList) {
		this.skuList = skuList;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@ApiModelProperty("英文名称")
	@Column(name = "en_name", length = 100, unique = true)
	private String enName;

	@ApiModelProperty("商品主图")
	@Column(name = "main_pic", length = 500, nullable = false)
	private String mainPic;

	@ApiModelProperty("店铺")
	@ManyToOne
	@JoinColumn(name = "store")
	private PcStore store;

	@ApiModelProperty("品牌")
	@ManyToOne
	@JoinColumn(name = "brand")
	private PcBrand brand;

	@ApiModelProperty("分类")
	@ManyToOne
	@JoinColumn(name = "category")
	private PcCategory category;

	@ApiModelProperty("最小销售价")
	@Column(name = "min_sell_price")
	private BigDecimal minSellPrice;

	@ApiModelProperty("最大销售价")
	@Column(name = "max_sell_price")
	private BigDecimal maxSellPrice;

	@ApiModelProperty("商品相册")
	@OneToOne
	@JoinColumn(name = "album")
	private PcAlbum album;

	@ApiModelProperty("状态")
	@ManyToOne
	@JoinColumn(name = "status")
	private PcProductStatus status;

	@ApiModelProperty("排序")
	@Column(name = "sort")
	private Integer sort;

	@ApiModelProperty("创建人")
	@Column(name = "create_user", length = 50, insertable = true, updatable = false, nullable = false)
	private String createUser;

	@ApiModelProperty("创建时间")
	@Column(name = "create_time", insertable = true, updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@ApiModelProperty("修改人")
	@Column(name = "update_user", length = 50, insertable = true, updatable = true, nullable = false)
	private String updateUser;

	@ApiModelProperty("修改时间")
	@Column(name = "update_time", insertable = true, updatable = true, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	@ApiModelProperty("商品标签")
	@OneToMany
	@JoinTable(name = "pc_product_label", joinColumns = { @JoinColumn(name = "product") }, inverseJoinColumns = {
			@JoinColumn(name = "label") })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<PcLabel> labels;

	@ApiModelProperty("商品关键字")
	@OneToMany
	@JoinTable(name = "pc_product_keyword", joinColumns = { @JoinColumn(name = "product") }, inverseJoinColumns = {
			@JoinColumn(name = "keyword") })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<PcKeyword> keywords;

	@ApiModelProperty("商品规格")
	@OneToMany
	@JoinColumn(name = "product")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<PcProductSpecification> specList;

	@ApiModelProperty("商品属性")
	@OneToMany
	@JoinColumn(name = "product")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<PcProductAttribute> attributeList;

	@ApiModelProperty("商品sku")
	@OneToMany
	@JoinColumn(name = "product")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<PcSku> skuList;

	@ApiModelProperty("商品评价")
	@OneToMany
	@JoinColumn(name = "product")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<PcProductComment> commentList;
}
