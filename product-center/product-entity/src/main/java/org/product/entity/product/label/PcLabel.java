package org.product.entity.product.label;

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
 * 描述: 商品标签 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:45:19
 */
@Getter
@Setter
@Entity
@Table(name = "pc_label")
public class PcLabel extends FlagEnabledEntity {

	private static final long serialVersionUID = -4182567408756072781L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 标签类型
	 */
	@ManyToOne
	@JoinColumn(name = "type")
	private PcLabelType type;
}
