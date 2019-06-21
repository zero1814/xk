package org.product.repository.product;

import java.util.Set;

import org.product.entity.PcPicture;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcSku;
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

	@Query("select pp.code, pp.name, pp.mainPic, pp.store, pp.brand, pp.category, pp.minSellPrice, pp.maxSellPrice, pp.status from PcProduct as pp where pp.code=:code")
	PcProduct getProduct(@Param("code") String code);

	@Query("select pp.skuList from PcProduct as pp where pp.code=:code")
	Set<PcSku> findSkuList(@Param("code") String code);

	@Query("select pp.pics from PcProduct as pp where pp.code=:code")
	Set<PcPicture> findProductPics(@Param("code") String code);

}
