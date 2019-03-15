package org.system.entity.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: ScCenterInfo <br>
 * 描述: 系统中心维护表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月15日 上午11:22:45
 */
@Entity
@Table(name = "sc_center_info")
public class ScCenterInfo extends BaseEntity {

	private static final long serialVersionUID = 606078852136137421L;
	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
	@Column(name = "url", length = 50, nullable = false, unique = true)
	private String url;
	@Column(name = "intro", length = 500)
	private String intro;
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
