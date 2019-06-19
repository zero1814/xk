package org.product.entity.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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

	public PcProduct(List<PcSku> skuList) {
		this.skuList = skuList;
	}

	public PcProduct(String code, PcStore store) {
		this.code = code;
		this.store = store;
	}

	public PcProduct(String code, String name, String enName, String mainPic, PcStore store, PcBrand brand,
			PcCategory category, BigDecimal minSellPrice, BigDecimal maxSellPrice, PcAlbum album,
			PcProductStatus status) {
		this.code = code;
		this.name = name;
		this.enName = enName;
		this.mainPic = mainPic;
		this.store = store;
		this.brand = brand;
		this.category = category;
		this.minSellPrice = minSellPrice;
		this.maxSellPrice = maxSellPrice;
		this.album = album;
		this.status = status;
	}

	public PcProduct(String code, String name, String enName, String mainPic, String storeCode, String storeName,
			String brandCode, String brandName, String categoryCode, String categoryName, BigDecimal minSellPrice,
			BigDecimal maxSellPrice, PcAlbum album, String statusCode, String statusName) {
		this.code = code;
		this.name = name;
		this.enName = enName;
		this.mainPic = mainPic;
		this.store = new PcStore(storeCode, storeName);
		this.brand = new PcBrand(brandCode, brandName);
		this.category = new PcCategory(categoryCode, categoryName);
		this.minSellPrice = minSellPrice;
		this.maxSellPrice = maxSellPrice;
		this.album = album;
		this.status = new PcProductStatus(statusCode, statusName);
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
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
	@ManyToOne(fetch = FetchType.EAGER)
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
	private Date createTime;

	@ApiModelProperty("修改人")
	@Column(name = "update_user", length = 50, insertable = true, updatable = true, nullable = false)
	private String updateUser;

	@ApiModelProperty("修改时间")
	@Column(name = "update_time", insertable = true, updatable = true, nullable = false)
	private Date updateTime;

	@ApiModelProperty("商品标签")
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinTable(name = "pc_product_label", joinColumns = {
			@JoinColumn(name = "product", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "label", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "product", "label" }) })
	private List<PcLabel> labels;

	@ApiModelProperty("商品关键字")
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinTable(name = "pc_product_keyword", joinColumns = {
			@JoinColumn(name = "product", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "keyword", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "product", "keyword" }) })
	private List<PcKeyword> keywords;

	@ApiModelProperty("商品规格")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "product")
	private List<PcProductSpecification> specList;

	@ApiModelProperty("商品属性")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "product")
	private List<PcProductAttribute> attributeList;

	@ApiModelProperty("商品sku")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REFRESH }, orphanRemoval = true)
	@JoinColumn(name = "product")
	private List<PcSku> skuList;

	@ApiModelProperty("商品评价")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
	@JoinColumn(name = "product")
	private List<PcProductComment> commentList;
}
