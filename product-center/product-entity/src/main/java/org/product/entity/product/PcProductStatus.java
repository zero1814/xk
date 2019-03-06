package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

@Entity
@Table(name="pc_product_status")
public class PcProductStatus extends BaseEntity {

	private static final long serialVersionUID = -6330335877354066179L;

	/**
	 * 名称
	 */
	@Column(name="name",length=50,nullable=false)
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}