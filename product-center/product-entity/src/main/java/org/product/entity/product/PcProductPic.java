package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

/**
 * 
 * 类: PcProductPic <br>
 * 描述: 商品图片 <br>
 * 作者: zhy<br>
 * 时间: 2019年2月15日 上午10:04:32
 */
@Entity
@Table(name = "pc_product_pic")
public class PcProductPic extends BaseEntity {

	private static final long serialVersionUID = -5273692513783580263L;

	/**
	 * 商品编码
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_code")
	private PcProductInfo productCode;

	/**
	 * 商品图片
	 */
	@Column(name = "pic_url", length = 200, nullable = false)
	private String picUrl;

	/**
	 * 排序
	 */
	@Column(name = "sort", columnDefinition = "bigint default 0")
	private Long sort;

	public PcProductInfo getProductCode() {
		return productCode;
	}

	public void setProductCode(PcProductInfo productCode) {
		this.productCode = productCode;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}