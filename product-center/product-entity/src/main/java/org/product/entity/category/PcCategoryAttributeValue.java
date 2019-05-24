package org.product.entity.category;

import org.zero.spring.mybatis.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="分类属性值")
public class PcCategoryAttributeValue extends BaseEntity {

	private static final long serialVersionUID = -6006382137233943383L;

	
	@ApiModelProperty(value="属性编码")
	private String attribute;
	@ApiModelProperty(value="属性值")
	private String value;
}