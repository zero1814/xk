package org.product.entity.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.zero.spring.mybatis.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("品牌")
public class PcBrand extends BaseEntity {

	private static final long serialVersionUID = -1504446260780341528L;

	@ApiModelProperty(value="父级编码")
	private String parent;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "logo")
	private String logo;

	@ApiModelProperty(value = "是否可用 0 可用 1 不可用")
	private Integer flagEnabled;

	@ApiModelProperty(value = "排序 越小排序越靠前")
	private Long sort;

}