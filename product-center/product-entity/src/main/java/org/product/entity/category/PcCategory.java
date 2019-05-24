package org.product.entity.category;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcCategory <br>
 * 描述: 商品分类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:56:54
 */
@Getter
@Setter
@Entity
@Table(name = "pc_category")
@ApiModel("商品分类管理")
public class PcCategory extends FlagEnabledEntity {

	private static final long serialVersionUID = 142846225528469454L;

	/**
	 * 父级编码
	 */
	@ApiModelProperty("父级编码")
	@ManyToOne
	@JoinColumn(name = "parent")
	private PcCategory parent;

	@OneToMany(mappedBy = "parent")
	private List<PcCategory> children;

	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	/**
	 * 图标
	 */
	@ApiModelProperty("图标")
	@Column(name = "icon", length = 100, nullable = false)
	private String icon;

	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
	@Column(name = "sort", columnDefinition = "bigint default 0")
	private Long sort;

	/**
	 * 分类属性集合
	 */
	@ApiModelProperty("分类属性集合")
	@OneToMany
	@JoinColumn(name = "category")
	private List<PcCategoryAttribute> attributes;

	@ApiModelProperty("分类参数集合")
	@OneToMany
	@JoinColumn(name = "category")
	private List<PcCategoryParam> params;
}
