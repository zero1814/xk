package org.product.entity.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="店铺")
public class PcStore extends BaseEntity {

	private static final long serialVersionUID = 4791822266398855375L;
	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "店铺logo")
	private String logo;

	@ApiModelProperty(value = "等级")
	private String level;

	@ApiModelProperty(value = "类型")
	private String type;

	@ApiModelProperty(value = "状态")
	private String status;
}