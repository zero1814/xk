package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="商品关键字")
public class PcProductKeywords extends BaseEntity {

	private static final long serialVersionUID = 8650754794059216593L;

	@ApiModelProperty("商品编码")
	private String product;

	@ApiModelProperty("商品关键字")
	private String keywords;

	@ApiModelProperty(value = "排序 默认0 越高越靠前")
	private Long sort;
}