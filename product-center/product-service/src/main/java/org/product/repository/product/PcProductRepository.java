package org.product.repository.product;

import org.product.entity.product.PcProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcProductRepository <br>
 * 描述: 商品数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:08:38
 */
public interface PcProductRepository extends BaseRepository<PcProduct, String> {

	@Query("select new PcProduct(code,new PcStore(code,name)) from PcProduct as p where p.code =:code")
	PcProduct getProduct(@Param("code") String code);
}
