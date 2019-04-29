package org.product.entity.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcActivityStatus <br>
 * 描述: 活动状态 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午2:50:12
 */
@Getter
@Setter
@Entity
@Table(name = "pc_activity_product")
public class PcActivityStatus extends FlagEnabledEntity {

	private static final long serialVersionUID = 5254869214130216041L;

	@Column(name = "name", length = 50, nullable = false)
	private String name;
}
