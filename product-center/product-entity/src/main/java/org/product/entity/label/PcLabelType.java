package org.product.entity.label;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Setter;

import lombok.Getter;

/**
 * 
 * 类: PcLabelType <br>
 * 描述: 标签类型 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:02:39
 */
@Getter
@Setter
@Entity
@Table(name = "pc_label_type")
public class PcLabelType extends BaseEntity {

	private static final long serialVersionUID = 828872861454832242L;

	@Column(name = "name", length = 50, nullable = false)
	private String name;
}
