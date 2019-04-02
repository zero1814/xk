package org.product.entity.label;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcLabelType <br>
 * 描述: 标签类型 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月2日 下午4:23:32
 */
@Getter
@Setter
@Entity
@Table(name = "pc_label")
public class PcLabelType extends BaseEntity {

	private static final long serialVersionUID = -5556770138096561546L;

	/**
	 * 名称
	 */
	@Column(name = "name")
	private String name;

}
