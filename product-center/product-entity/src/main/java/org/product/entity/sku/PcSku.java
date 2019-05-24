package org.product.entity.sku;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="商品Sku")
public class PcSku extends BaseEntity {

	private static final long serialVersionUID = -8995074663716566517L;

	@ApiModelProperty(value="商品编码")
	private String product;

	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value="主图")
	private String mainPic;

	@ApiModelProperty(value = "成本价")
	private BigDecimal costPrice;

	@ApiModelProperty(value = "市场价")
	private BigDecimal marketPrice;

	@ApiModelProperty(value="销售价")
	private BigDecimal sellPrice;

	@ApiModelProperty(value = "sku相册")
	private String album;

	@ApiModelProperty(value = "库存")
	private Long stock;

	@ApiModelProperty(value = "预警库存")
	private Long warnStock;

	@ApiModelProperty(value = "状态")
	private String status;

}