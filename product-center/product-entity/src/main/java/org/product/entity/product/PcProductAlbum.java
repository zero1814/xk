package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcProductAlbum <br>
 * 描述: 商品相册 <br>
 * 作者: zhy<br>
 * 时间: 2019年3月25日 上午11:58:32
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product_album")
public class PcProductAlbum extends BaseEntity {

	private static final long serialVersionUID = 6512291861674006179L;

	@ManyToOne
	@JoinColumn(name = "product_code")
	private PcProduct product;

	@Column(name = "url", length = 200, nullable = false)
	private String url;

}
