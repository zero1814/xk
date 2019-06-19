package org.product.repository.product;

import java.util.List;

import org.product.entity.product.PcProductAttribute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface PcProductAttributeRepository extends BaseRepository<PcProductAttribute, String> {

	@Query(nativeQuery=true,value="select code,name,value,sort from pc_product_attribute where product=:product")
	List<Object> findProductAttribute(@Param("product") String product);
}
