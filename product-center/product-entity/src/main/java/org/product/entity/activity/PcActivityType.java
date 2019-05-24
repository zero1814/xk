package org.product.entity.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="活动类型")
public class PcActivityType extends BaseEntity {

	/**  */
	private static final long serialVersionUID = -5211420799280638808L;

	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value = "是否启用 0 未启用 1 已启用")
	private Integer flagEnabled;

}