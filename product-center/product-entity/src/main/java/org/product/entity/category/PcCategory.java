package org.product.entity.category;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_category")
@ApiModel(value = "商品分类管理")
public class PcCategory extends BaseEntity {

	private static final long serialVersionUID = 142846225528469454L;

	public PcCategory() {
	}

	public PcCategory(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public PcCategory(String code, String name, String icon, Integer flagEnabled, Integer sort) {
		super();
		this.code = code;
		this.name = name;
		this.icon = icon;
		this.flagEnabled = flagEnabled;
		this.sort = sort;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, nullable = true, unique = true)
	private String name;

	@ApiModelProperty("分类图标")
	@Column(name = "icon", length = 200)
	private String icon;

	@ApiModelProperty("是否可用 0 可用 1 不可用")
	@Column(name = "flag_enabled")
	private Integer flagEnabled;

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

	@ApiModelProperty("分类通用规格参数")
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "category")
	private List<PcCategorySpecification> sepcList;

	@ApiModelProperty("分类通用属性")
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "category")
	private List<PcCategoryAttribute> attributeList;
}
