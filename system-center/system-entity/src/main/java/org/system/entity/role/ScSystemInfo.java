package org.system.entity.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.system.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: ScSystemInfo <br>
 * 描述: 系统中心表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月19日 下午2:54:10
 */
@Getter
@Setter
@Entity
@Table(name = "sc_system_info")
public class ScSystemInfo extends FlagEnabledEntity {

	private static final long serialVersionUID = 63274846972520851L;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	@Column(name = "short_name", length = 50, nullable = false, unique = true)
	private String shortName;

	@Column(name = "intro", length = 500)
	private String intro;

}
