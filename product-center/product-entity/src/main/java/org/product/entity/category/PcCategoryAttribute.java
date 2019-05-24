package org.product.entity.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="分类参数")
public class PcCategoryAttribute extends BaseEntity {

	private static final long serialVersionUID = -4775797807169333942L;

	@ApiModelProperty(value="分类编码")
	private String category;

	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value="默认值")
	private String defaultValue;

	@ApiModelProperty(value = "排序 默认0 越高越靠后")
	private Long sort;

}