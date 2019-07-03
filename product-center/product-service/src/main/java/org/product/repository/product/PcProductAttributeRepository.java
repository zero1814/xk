package org.product.repository.product;

import java.util.List;

import org.product.entity.product.PcProductAttribute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface PcProductAttributeRepository extends BaseRepository<PcProductAttribute, String> {

	@Query(nativeQuery=true,value="SELECT ppa.code,ppa.name,ppa.sort,ppav.code AS attr_key,ppav.value AS attr_value,ppav.sort as attr_sort FROM pc_product_attribute_value AS ppav LEFT JOIN pc_product_attribute AS ppa ON ppav.attribute = ppa.code ORDER BY ppa.sort,ppav.sort")
	List<Object> findProductAttribute(@Param("product") String product);

	@Query(nativeQuery = true, value = "delete from pc_product_attribute where product=:product")
	int deleteAttributeByProduct(@Param("product") String product);

	@Query(nativeQuery = true, value = "select count(1) from pc_sku_attribute where attribute=:attribute")
	int skuConcatAttribute(@Param("attribute") String attribute);
}
