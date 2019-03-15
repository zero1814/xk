package org.system.entity.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.zero.spring.jpa.BaseEntity;

@Entity
@Table(name = "sc_api_info", uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "url", "center" }) })
public class ScApiInfo extends BaseEntity {

	private static final long serialVersionUID = -8444890942860733346L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 访问url
	 */
	@Column(name = "url", length = 50, nullable = false)
	private String url;

	/**
	 * 系统中心编码
	 */
	@ManyToOne
	@JoinColumn(name = "center")
	private ScCenterInfo center;

	/**
	 * 接口描述
	 */
	@Column(name = "intro", length = 500)
	private String intro;

	/**
	 * 是否可用 0 可用 1 不可用
	 */
	@Column(name = "flag_enabled", columnDefinition = "int null default 0")
	private Integer flagEnabled;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ScCenterInfo getCenter() {
		return center;
	}

	public void setCenter(ScCenterInfo center) {
		this.center = center;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getFlagEnabled() {
		return flagEnabled;
	}

	public void setFlagEnabled(Integer flagEnabled) {
		this.flagEnabled = flagEnabled;
	}

}
