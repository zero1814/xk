package org.product.entity.store;

import org.zero.spring.mybatis.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "店铺类型")
public class PcStoreType extends BaseEntity {

	private static final long serialVersionUID = -6612665630055736856L;

	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "是否启用 0 未启用 1 已启用")
	private Integer flagEnabled;
}