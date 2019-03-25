package org.product.entity.product;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

/**
 * 
 * 类: PcCategory <br>
 * 描述: 商品分类 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:26:23
 */
@Entity
@Table(name = "pc_category")
public class PcCategory extends FlagEnabledEntity {

	private static final long serialVersionUID = -316067999397194462L;

	/**
	 * 名称
	 */
	@Column(name = "name", unique = true, length = 50, nullable = false)
	private String name;

	@OneToMany
	@JoinColumn(name = "category_code")
	private List<PcCategoryAttribute> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
