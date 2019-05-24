package org.product.entity.product;

import org.zero.spring.mybatis.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="关键字")
public class PcKeywords extends BaseEntity {

	private static final long serialVersionUID = -7854992961391608511L;
	@ApiModelProperty(value="名称")
	private String name;
}