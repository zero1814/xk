package org.product.entity.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("活动商品")
public class PcActivityProduct extends BaseEntity {

	private static final long serialVersionUID = -7687829363282178105L;

	@ApiModelProperty(value = "店铺编码")
	private String store;

	@ApiModelProperty(value = "活动编码")
	private String activity;

	@ApiModelProperty(value = "商品编码")
	private String product;

	@ApiModelProperty(value = "商品库存")
	private Long stock;

}