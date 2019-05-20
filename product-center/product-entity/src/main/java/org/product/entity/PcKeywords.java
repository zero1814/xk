package org.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;

import lombok.Getter;

/**
 * 
 * 类: PcKeywords <br>
 * 描述: 常用关键字 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:00:12
 */
@Getter
@Setter
@Entity
@Table(name = "pc_keywords")
@ApiModel(value = "关键字管理")
public class PcKeywords extends BaseEntity {

	private static final long serialVersionUID = 4282498594161743388L;

	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	@Column(name = "name", length = 50, nullable = false)
	private String name;
}
