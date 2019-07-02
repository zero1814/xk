package org.product.repository.product;

import java.util.List;
import java.util.Set;

import org.product.entity.PcKeyword;
import org.product.entity.PcLabel;
import org.product.entity.PcPicture;
import org.product.entity.product.PcProduct;
import org.product.entity.product.PcProductAttribute;
import org.product.entity.product.PcProductSpecification;
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

	@Query("select new PcProduct(pp.code, pp.name, pp.mainPic, pp.store.code as storeCode, pp.store.name as storeName, pp.brand.code as brandCode, pp.brand.name as brandName, pp.category.code as categoryCode, pp.category.name as categoryName,pp.minSellPrice, pp.maxSellPrice, pp.status.code as statusCode, pp.status.name as statusName) from PcProduct as pp where pp.code=:code")
	PcProduct getProduct(@Param("code") String code);

	@Query("select pp.labels from PcProduct as pp where pp.code=:code")
	Set<PcLabel> findLabels(@Param("code") String code);

	@Query("select pp.keywords from PcProduct as pp where pp.code=:code")
	Set<PcKeyword> findkeywords(@Param("code") String code);

	@Query("select pp.pics from PcProduct as pp where pp.code=:code")
	Set<PcPicture> findProductPics(@Param("code") String code);

	@Query("select pp.specList from PcProduct as pp where pp.code=:code")
	List<PcProductSpecification> findProductSpecificationData(@Param("code") String code);
	
	@Query("select pp.attributeList from PcProduct as pp where pp.code=:code")
	List<PcProductAttribute> findProductAttibuteData(@Param("code") String code);
}
