package org.product.entity.product;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_activity_spec")
public class PcProductSpec extends BaseEntity {

	private static final long serialVersionUID = -3315204042315937888L;

	private PcProduct product;
}
