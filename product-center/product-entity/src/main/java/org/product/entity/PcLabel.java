package org.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcLabel <br>
 * 描述: 标签 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:01:38
 */
@Getter
@Setter
@Entity
@Table(name = "pc_label")
@ApiModel(value = "标签管理")
public class PcLabel extends FlagEnabledEntity {

	private static final long serialVersionUID = -7050210879948252806L;

	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 类型 1 商品 2 店铺
	 */
	@ApiModelProperty("类型 1 商品 2 店铺")
	@Column(name = "type", columnDefinition = "bigint default 0")
	private Integer type;

	/**
	 * 显示优先级 数值越高显示越靠前
	 * 
	 */
	@ApiModelProperty("显示优先级 数值越高显示越靠前")
	@Column(name = "sort", columnDefinition = "bigint default 0")
	private Long sort;

}
