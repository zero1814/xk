package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "商品标签关系表")
public class PcProductLabel extends BaseEntity {

	private static final long serialVersionUID = 4156336791458441921L;

	@ApiModelProperty("商品编码")
	private String product;

	@ApiModelProperty(value = "商品标签 填写的是标签的世纪至")
	private String label;

	@ApiModelProperty(value = "排序 值越打越靠前")
	private Long sort;

}