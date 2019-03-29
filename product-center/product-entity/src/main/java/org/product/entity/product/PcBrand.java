package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcBrand <br>
 * 描述: 商品品牌表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:26:11
 */
@Getter
@Setter
@Entity
@Table(name = "pc_brand")
public class PcBrand extends FlagEnabledEntity {

	private static final long serialVersionUID = -4160296791564644332L;

	/**
	 * 名称
	 */
	@Column(name = "name", unique = true, nullable = false, length = 50)
	private String name;

	/**
	 * 英文简称
	 */
	@Column(name = "en_name", unique = true, nullable = false, length = 50)
	private String enName;

	/**
	 * 品牌logo
	 */
	@Column(name = "logo_url", nullable = false, length = 200)
	private String logoUrl;

	/**
	 * 品牌简述
	 */
	@Column(name = "intro", length = 500)
	private String intro;

}
