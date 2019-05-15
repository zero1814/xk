package org.product.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zero.spring.jpa.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 类: PcProductKeywords <br>
 * 描述: 商品关键字 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:48:59
 */
@Getter
@Setter
@Entity
@Table(name = "pc_product_keywords")
public class PcProductKeywords extends BaseEntity {

	private static final long serialVersionUID = -102423774925906824L;


	/**
	 * 关键字
	 */
	@Column(name = "keyword", length = 100, nullable = false)
	private String keyword;
}
