package org.product.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcBrand <br>
 * 描述: 商品品牌 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:51:22
 */
@Getter
@Setter
@Entity
@Table(name = "pc_brand")
@ApiModel(value = "品牌管理")
public class PcBrand extends BaseEntity {

	private static final long serialVersionUID = 8062249932920020241L;

	public PcBrand() {

	}

	public PcBrand(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50)
	private String code;

	@ApiModelProperty("父级品牌")
	@ManyToOne
	@JoinColumn(name = "parent")
	private PcBrand parent;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@ApiModelProperty("品牌图标")
	@Column(name = "icon", length = 200, nullable = false)
	private String icon;

	@ApiModelProperty("品牌LOGO")
	@Column(name = "logo", length = 200, nullable = false)
	private String logo;

	@ApiModelProperty("是否可用 0 可用 1 不可用")
	@Column(name = "flag_enabled")
	private Integer flagEnabled;

	@ApiModelProperty("排序 越大越靠前")
	@Column(name = "sort", columnDefinition = " bigint default 0 ")
	private Long sort;

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

	@ApiModelProperty("子分类集合")
	@OneToMany(mappedBy = "parent")
	private List<PcBrand> children;
}
