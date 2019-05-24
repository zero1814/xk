package org.product.entity.sku;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="商品Sku状态")
public class PcSkuStatus extends BaseEntity {

	private static final long serialVersionUID = 2085517132846565461L;
	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value = "是否可用 0 可用 1 不可用")
	private Integer flagEnabled;
}