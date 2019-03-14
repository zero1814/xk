package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: PcBrandInfo <br>
 * 描述: 商品品牌表 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月15日 上午9:48:04
 */
@Entity
@Table(name = "pc_brand_info")
public class PcBrandInfo extends BaseEntity {

	private static final long serialVersionUID = 8328486928128907182L;

	public PcBrandInfo() {

	}

	public PcBrandInfo(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

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
	 * 品牌图标url
	 */
	@Column(name = "logo_url", length = 200, nullable = false)
	private String logoUrl;

	/**
	 * 是否可用 0 可用 1 不可用
	 */
	@Column(name = "flag_enabled", columnDefinition = "int default 0", nullable = true)
	private Integer flagEnabled;

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

	public Integer getFlagEnabled() {
		return flagEnabled;
	}

	public void setFlagEnabled(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}