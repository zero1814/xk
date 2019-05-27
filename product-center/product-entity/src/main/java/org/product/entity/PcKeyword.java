package org.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;

import lombok.Getter;

/**
 * 
 * 类: PcKeyword <br>
 * 描述: 常用关键字 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:00:12
 */
@Getter
@Setter
@Entity
@Table(name = "pc_keyword")
@ApiModel(value = "关键字管理")
public class PcKeyword extends BaseEntity {

	private static final long serialVersionUID = 4282498594161743388L;

	public PcKeyword() {

	}

	public PcKeyword(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50)
	private String code;

	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	@ApiModelProperty("是否可用 0 可用 1 不可用")
	@Column(name = "flag_enabled")
	private Integer flagEnabled;

	@ApiModelProperty("创建人")
	@Column(name = "create_user", length = 50, insertable = true, updatable = false, nullable = false)
	private String createUser;

	@ApiModelProperty("创建时间")
	@Column(name = "create_time", insertable = true, updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@ApiModelProperty("修改人")
	@Column(name = "update_user", length = 50, insertable = true, updatable = true, nullable = false)
	private String updateUser;

	@ApiModelProperty("修改时间")
	@Column(name = "update_time", insertable = true, updatable = true, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
}
