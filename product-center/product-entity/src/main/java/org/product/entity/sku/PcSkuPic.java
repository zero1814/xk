package org.product.entity.sku;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

@Entity
@Table(name = "pc_sku_pic")
public class PcSkuPic extends BaseEntity {

	private static final long serialVersionUID = 4226790008540386566L;

	@ManyToOne
	@JoinColumn(name = "sku_code")
	private PcSkuInfo skuCode;

	@Column(name = "pic_url", length = 200, nullable = false)
	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public PcSkuInfo getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(PcSkuInfo skuCode) {
		this.skuCode = skuCode;
	}

}