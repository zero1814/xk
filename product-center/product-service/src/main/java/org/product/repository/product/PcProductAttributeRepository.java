package org.product.repository.product;

import java.util.List;

import org.product.entity.product.PcProductAttribute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface PcProductAttributeRepository extends BaseRepository<PcProductAttribute, String> {

	@Query("from pc_product_attribute as ppa where ppa.product.code=:product")
	List<Object> findProductAttribute(@Param("product") String product);

	@Query(nativeQuery = true, value = "select count(1) from pc_product_attribute where product=:product")
	Long findProductAttributeTotal(@Param("product") String product);

	@Query(nativeQuery = true, value = "delete from pc_product_attribute where product=:product")
	int deleteAttributeByProduct(@Param("product") String product);

	@Query(nativeQuery = true, value = "select count(1) from pc_sku_attribute where attribute=:attribute")
	int skuConcatAttribute(@Param("attribute") String attribute);
}
