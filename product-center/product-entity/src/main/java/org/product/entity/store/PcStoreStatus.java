package org.product.entity.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcStoreStatus <br>
 * 描述: 店铺状态 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:33:39
 */
@Getter
@Setter
@Entity
@Table(name = "pc_store_status")
public class PcStoreStatus extends FlagEnabledEntity{

	private static final long serialVersionUID = 3294614608694263914L;
	
	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

}
