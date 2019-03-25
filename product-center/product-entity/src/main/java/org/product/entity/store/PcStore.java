package org.product.entity.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: PcStore <br>
 * 描述: 店铺表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:36:09
 */
@Entity
@Table(name = "pc_store")
public class PcStore extends BaseEntity {

	private static final long serialVersionUID = 7322069145607276341L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, unique = true, nullable = false)
	private String name;

	/**
	 * 店铺logo
	 */
	@Column(name = "logo_url", length = 200, nullable = false)
	private String logoUrl;

	/**
	 * 负责人
	 */
	@Column(name = "principal_name", length = 50, nullable = false)
	private String principalName;

	/**
	 * 负责人电话
	 */
	@Column(name = "principal_phone", length = 20, nullable = false)
	private String principalPhone;

	/**
	 * 店铺等级
	 */
	@ManyToOne
	@JoinColumn(name = "level")
	private PcStoreLevel level;
	/**
	 * 状态
	 */
	@ManyToOne
	@JoinColumn(name = "status")
	private PcStoreStatus status;

	/**
	 * 店铺简介
	 */
	@Column(name = "intro", length = 500)
	private String intro;

	public PcStoreLevel getLevel() {
		return level;
	}

	public void setLevel(PcStoreLevel level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getPrincipalPhone() {
		return principalPhone;
	}

	public void setPrincipalPhone(String principalPhone) {
		this.principalPhone = principalPhone;
	}

	public PcStoreStatus getStatus() {
		return status;
	}

	public void setStatus(PcStoreStatus status) {
		this.status = status;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
