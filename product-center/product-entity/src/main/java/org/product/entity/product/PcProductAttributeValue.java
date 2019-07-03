package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_product_attribute_value")
@ApiModel(value = "商品属性值管理")
public class PcProductAttributeValue extends BaseEntity {

	private static final long serialVersionUID = 8272459768772710194L;

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;

	@ApiModelProperty("属性值")
	@Column(name = "value", length = 100, nullable = false)
	private String value;

	@ApiModelProperty("排序")
	@Column(name = "sort", columnDefinition = "int default 0 comment '排序'", nullable = false)
	private Integer sort;
}
