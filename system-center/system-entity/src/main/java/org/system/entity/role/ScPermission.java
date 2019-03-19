package org.system.entity.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.system.entity.FlagEnabledEntity;

@Entity
@Table(name = "sc_permission", uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "url", "system_center" }) })
public class ScPermission extends FlagEnabledEntity {

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
	 * 系统中心简称
	 */
	@ManyToOne
	@JoinColumn(name = "system_center")
	private ScSystemInfo systemCenter;

	@Column(name = "intro", length = 500)
	private String intro;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public ScSystemInfo getSystemCenter() {
		return systemCenter;
	}

	public void setSystemCenter(ScSystemInfo systemCenter) {
		this.systemCenter = systemCenter;
	}

}
