package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "商品")
public class PcProduct extends BaseEntity {

	private static final long serialVersionUID = 7634850028796240689L;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "英文名称")
	private String enName;

	@ApiModelProperty(value = "主图")
	private String mainPic;

	@ApiModelProperty(value = "商品相册")
	private String album;

	@ApiModelProperty(value = "店铺编码")
	private String store;

	@ApiModelProperty(value = "品牌编码")
	private String brand;
	@ApiModelProperty(value = "分类编码")
	private String category;

	@ApiModelProperty(value = "最小销售价")
	private BigDecimal minSellPrice;

	@ApiModelProperty(value = "最大销售价")
	private BigDecimal maxSellPrice;

	@ApiModelProperty(value = "状态")
	private String status;

	@ApiModelProperty(value = "排序")
	private Long sort;

}