package org.product.entity.category;

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
@Table(name = "pc_category_attribute_value")
@ApiModel(value = "商品分类属性值管理")
public class PcCategoryAttributeValue extends BaseEntity {

	private static final long serialVersionUID = 3334564301410737003L;

	/**
	 * 名称
	 */
	@ApiModelProperty("属性值")
	@Column(name = "value", length = 50, nullable = false, unique = true)
	private String value;
}
