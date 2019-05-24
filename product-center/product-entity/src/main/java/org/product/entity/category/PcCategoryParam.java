package org.product.entity.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="分类参数")
public class PcCategoryParam extends BaseEntity {

	private static final long serialVersionUID = 1139010202360618152L;
	@ApiModelProperty(value="分类编码")
	private String category;
	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value = "是否可用 0 可用 1 不可用")
	private Integer flagEnabled;

}