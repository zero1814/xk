package org.product.entity.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="店铺等级")
public class PcStoreLevel extends BaseEntity {

	private static final long serialVersionUID = -6181988592967034206L;
	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value = "是否启用 0 未启用 1 已启用")
	private Integer flagEnabled;

}