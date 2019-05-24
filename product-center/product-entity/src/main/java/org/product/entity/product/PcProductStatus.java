package org.product.entity.product;

import org.zero.spring.mybatis.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="商品状态")
public class PcProductStatus extends BaseEntity {

	private static final long serialVersionUID = -6330335877354066179L;

	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value = "是否可用 0 可用 1 不可用")
	private Integer flagEnabled;
}