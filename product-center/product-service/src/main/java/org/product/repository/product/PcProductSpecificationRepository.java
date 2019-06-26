package org.product.repository.product;

import java.util.List;

import org.product.entity.product.PcProductSpecification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface PcProductSpecificationRepository extends BaseRepository<PcProductSpecification, String> {

	@Query(nativeQuery=true,value="select code,name,value,sort from pc_product_specification where product=:product")
	List<Object> findProductSpecification(@Param("product") String product);
	
	@Query(nativeQuery = true, value = "select count(1) from pc_product_specification where product=:product")
	Long findProductSpecificationTotal(@Param("product") String product);
	
	@Query(nativeQuery = true, value = "delete from pc_product_specification where product=:product")
	int deleteSpecificationByProduct(@Param("product") String product);
}
