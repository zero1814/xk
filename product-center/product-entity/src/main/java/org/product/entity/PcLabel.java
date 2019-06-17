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
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcLabel <br>
 * 描述: 标签 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:01:38
 */
@Getter
@Setter
@Entity
@Table(name = "pc_label")
@ApiModel(value = "标签管理")
public class PcLabel extends BaseEntity {

	private static final long serialVersionUID = -7050210879948252806L;

	public PcLabel() {

	}

	public PcLabel(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@ApiModelProperty("编码")
	@Id
	@Column(name = "code", length = 50, updatable = false)
	private String code;
	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	/**
	 * 类型 1 商品 2 店铺
	 */
	@ApiModelProperty("类型 1 商品 2 店铺")
	@Column(name = "type", columnDefinition = "bigint default 0")
	private Integer type;

	@ApiModelProperty("是否可用 0 可用 1 不可用")
	@Column(name = "flag_enabled")
	private Integer flagEnabled;
	/**
	 * 显示优先级 数值越高显示越靠前
	 * 
	 */
	@ApiModelProperty("显示优先级 数值越高显示越靠前")
	@Column(name = "sort", columnDefinition = "bigint default 0")
	private Long sort;

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
