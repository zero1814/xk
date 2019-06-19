package org.product.repository.product;

import java.util.List;

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

	@Query("select new PcProduct(p.code,p.name,p.enName,p.mainPic,p.store.code as storeCode,p.store.name as storeName,p.brand.code as brandCode,p.brand.name as brandName,p.category.code as categoryCode,p.category.name as categoryName,minSellPrice,maxSellPrice,album,p.status.code as statusCode,p.status.name as statusName) from PcProduct p where p.code='PP1140872842812846086'")
	PcProduct getProduct(String code);

	@Query("select new PcSku(ps.code, ps.name, ps.mainPic, ps.costPrice, ps.marketPrice, ps.sellPrice, ps.stock, ps.warnStock,ps.status.code as statusCode,ps.status.name as statusName) from PcProduct pp join pp.skuList ps where pp.code=:code")
	List<PcSku> findSkuList(@Param("code") String code);

}
