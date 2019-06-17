package org.product.entity.category;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_category_attribute", uniqueConstraints = { @UniqueConstraint(columnNames = { "category", "name" }) })
@ApiModel(value = "商品分类通用属性管理")
public class PcCategoryAttribute extends BaseEntity {

	private static final long serialVersionUID = 3932500996249032762L;

	public PcCategoryAttribute() {
	}

	public PcCategoryAttribute(String code, String name, String defaultValue, Integer sort) {
		this.code = code;
		this.name = name;
		this.defaultValue = defaultValue;
		this.sort = sort;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 50)
	private String name;

	@ApiModelProperty("默认可选值，多选使用','隔开")
	@Column(name = "default_value", length = 500)
	private String defaultValue;

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
}
