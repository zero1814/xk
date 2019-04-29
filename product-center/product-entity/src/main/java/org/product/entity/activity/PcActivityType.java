package org.product.entity.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pc_activity_type")
public class PcActivityType extends FlagEnabledEntity {

	private static final long serialVersionUID = 3037597503569263399L;

	@Column(name = "name", length = 100, nullable = false)
	private String name;
}
