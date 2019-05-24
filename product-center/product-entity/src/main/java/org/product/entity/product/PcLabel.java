package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="标签")
public class PcLabel extends BaseEntity {

	private static final long serialVersionUID = -3746381321041170841L;

	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value = "标签类型 如:商品标签 店铺标签等")
	private String type;

	@ApiModelProperty(value = "是否可用 0 可用 1 不可用")
	private Integer flagEnabled;

	@ApiModelProperty(value = "显示优先级 数值越高显示越靠前")
	private Long sort;
}