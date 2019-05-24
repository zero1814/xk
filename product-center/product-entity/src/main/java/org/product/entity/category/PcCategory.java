package org.product.entity.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="商品分类")
public class PcCategory extends BaseEntity {

	private static final long serialVersionUID = 4209875016729973892L;

	@ApiModelProperty(value="父级编码")
	private String parent;

	@ApiModelProperty(value = "店铺编码")
	private String store;

	@ApiModelProperty(value="名称")
	private String name;

	@ApiModelProperty(value="图标")
	private String icon;

	@ApiModelProperty(value = "是否可用 0 可用 1 不可用")
	private Integer flagEnabled;

	@ApiModelProperty(value = "排序")
	private Long sort;

}