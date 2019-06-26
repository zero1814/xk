package org.product.repository.product;

import java.util.Set;

import org.product.entity.product.PcSku;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcSkuRepository <br>
 * 描述: 商品sku数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午4:11:29
 */
public interface PcSkuRepository extends BaseRepository<PcSku, String> {
	@Query("select ps from PcSku ps  where ps.code=:code")
	PcSku findSku(@Param("code") String code);

	@Query("select new PcSku(ps.code, ps.name, ps.mainPic, ps.costPrice, ps.marketPrice, ps.sellPrice, ps.stock, ps.warnStock) from PcSku as ps where ps.product.code=:product")
	Set<PcSku> findProductSkuList(@Param("product") String code);
}
