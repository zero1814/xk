package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_product_specification")
@ApiModel(value = "商品规格参数管理")
public class PcProductSpecification extends BaseEntity {

	private static final long serialVersionUID = 8699451341546241659L;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@ApiModelProperty("值")
	@Column(name = "value", length = 500, nullable = false)
	private String value;

	@ApiModelProperty("排序")
	@Column(name = "sort", length = 100, nullable = false)
	private Integer sort;
}
