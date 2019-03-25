package org.product.entity.store;

import javax.persistence.Table;

import org.product.entity.FlagEnabledEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 
 * 类: PcStoreLevel <br>
 * 描述: 店铺等级表 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:44:24
 */
@Entity
@Table(name = "pc_store_level")
public class PcStoreLevel extends FlagEnabledEntity {

	private static final long serialVersionUID = -3709591956935600566L;

	/**
	 * 名称
	 */
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	/**
	 * 等级描述
	 */
	@Column(name = "intro", length = 500)
	private String intro;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
