package org.product.entity.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="活动状态")
public class PcActivityStatus extends BaseEntity {

	private static final long serialVersionUID = 8715892816176372490L;

	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value = "是否可用 0 可用 1 不可用")
	private Integer flagEnabled;
}