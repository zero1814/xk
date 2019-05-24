package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "商品规格")
public class PcProductSpec extends BaseEntity {

	private static final long serialVersionUID = -7927036048168510067L;

	@ApiModelProperty("商品编码")
	private String product;

	@ApiModelProperty("规格名称")
	private String specKey;

	@ApiModelProperty("规格值")
	private String specValue;

	@ApiModelProperty(value = "类型 0 自动 1 手动")
	private Integer type;

	@ApiModelProperty(value = "排序 默认0 越高越靠后")
	private Long sort;

}