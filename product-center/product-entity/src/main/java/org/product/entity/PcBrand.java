package org.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcBrand <br>
 * 描述: 商品品牌 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:51:22
 */
@Getter
@Setter
@Entity
@Table(name = "pc_brand")
@ApiModel(value = "品牌管理")
public class PcBrand extends FlagEnabledEntity {

	private static final long serialVersionUID = 8062249932920020241L;

	/**
	 * 父级编码
	 */
	@ApiModelProperty("父级品牌")
	@ManyToOne
	@JoinColumn(name = "parent")
	private PcBrand parent;

	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	/**
	 * 图标
	 */
	@ApiModelProperty("品牌图标")
	@Column(name = "icon", length = 200, nullable = false)
	private String icon;

	/**
	 * logo
	 */
	@Column(name = "品牌logo", length = 200, nullable = false)
	private String logo;

	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
	@Column(name = "sort", columnDefinition = " bigint default 0 ")
	private Long sort;

}
