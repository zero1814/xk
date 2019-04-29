package org.product.entity.label;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

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
public class PcLabel extends FlagEnabledEntity {

	private static final long serialVersionUID = -7050210879948252806L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 类型
	 */
	@ManyToOne
	@JoinColumn(name = "type")
	private PcLabelType type;

	/**
	 * 显示优先级 数值越高显示越靠前
	 * 
	 */
	@Column(name = "sort", columnDefinition = "bigint default 0")
	private Long sort;
}
