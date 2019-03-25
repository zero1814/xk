package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

/**
 * 
 * 类: PcBrand <br>
 * 描述: 商品品牌表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:26:11
 */
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

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
