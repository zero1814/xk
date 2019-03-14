package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: PcProdutDraft <br>
 * 描述: 商品草稿箱 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月15日 上午10:16:06
 */
@Entity
@Table(name = "pc_product_draft")
public class PcProductDraft extends BaseEntity {

	private static final long serialVersionUID = 7082083721940584490L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 英文名称
	 */
	@Column(name = "en_name", length = 50, nullable = false)
	private String enName;

	/**
	 * 商品信息数据
	 */
	@Column(name = "data", length = 1000, nullable = false)
	private String data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}