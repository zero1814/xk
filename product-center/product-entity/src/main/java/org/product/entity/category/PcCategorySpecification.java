package org.product.entity.category;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_category_specification", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "category", "name" }) })
@ApiModel(value = "商品分类通用规格参数管理")
public class PcCategorySpecification extends BaseEntity {

	private static final long serialVersionUID = 139696118822260004L;

	public PcCategorySpecification() {

	}

	public PcCategorySpecification(String code, String name, String defaultValue, Integer sort) {
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

}
