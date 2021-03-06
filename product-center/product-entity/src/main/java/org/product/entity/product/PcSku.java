package org.product.entity.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.product.entity.PcPicture;
import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_sku")
@ApiModel(value = "商品sku管理")
public class PcSku extends BaseEntity {

	private static final long serialVersionUID = -9059563854277341590L;

	public PcSku() {

	}

	public PcSku(String code, String name, String mainPic, BigDecimal costPrice, BigDecimal marketPrice,
			BigDecimal sellPrice, Long stock, Long warnStock) {

		this.code = code;
		this.name = name;
		this.mainPic = mainPic;
		this.costPrice = costPrice;
		this.marketPrice = marketPrice;
		this.sellPrice = sellPrice;
		this.stock = stock;
		this.warnStock = warnStock;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("商品")
	@ManyToOne
	@JoinColumn(name = "product")
	private PcProduct product;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@ApiModelProperty("商品主图")
	@Column(name = "main_pic", length = 500, nullable = false)
	private String mainPic;

	@ApiModelProperty("成本价")
	@Column(name = "cost_price")
	private BigDecimal costPrice;

	@ApiModelProperty("市场价")
	@Column(name = "market_price")
	private BigDecimal marketPrice;

	@ApiModelProperty("销售价")
	@Column(name = "sell_price")
	private BigDecimal sellPrice;

	@ApiModelProperty("库存")
	@Column(name = "stock")
	private Long stock;

	@ApiModelProperty("预警库存")
	@Column(name = "warn_stock")
	private Long warnStock;

	@ApiModelProperty("是否已删除 0 未删除  1 已删除")
	@Column(name = "flag_deleted", columnDefinition = "int  default 0 ", nullable = false)
	private Integer flagDeleted;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "status")
	private PcProductStatus status;

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

	@ApiModelProperty("sku属性")
	@ManyToMany
	@JoinTable(name = "pc_sku_attribute", joinColumns = {
			@JoinColumn(name = "sku", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "attribute", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "sku", "attribute" }) })
	private Set<PcProductAttributeValue> attributes;

	@ApiModelProperty("sku属性")
	@ManyToMany
	@JoinTable(name = "pc_sku_specification", joinColumns = {
			@JoinColumn(name = "sku", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "specification", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "sku", "specification" }) })
	private Set<PcProductSpecificationValue> specifications;

	@ApiModelProperty("sku相册")
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "pc_sku_picture", joinColumns = {
			@JoinColumn(name = "sku", unique = false) }, inverseJoinColumns = {
					@JoinColumn(name = "picture", unique = false) }, uniqueConstraints = {
							@UniqueConstraint(columnNames = { "sku", "picture" }) })
	private Set<PcPicture> pics;
}
