package org.system.entity.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.system.entity.FlagEnabledEntity;

@Entity
@Table(name = "sc_permission", uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "url", "center" }) })
public class ScPermission extends FlagEnabledEntity {

	private static final long serialVersionUID = -8444890942860733346L;

	/**
	 * 访问url
	 */
	@Column(name = "url", length = 50, nullable = false)
	private String url;

	/**
	 * 系统中心简称
	 */
	@Column(name = "url", length = 20, nullable = false)
	private String center;

	@Column(name = "url", length = 500)
	private String intro;

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

}
