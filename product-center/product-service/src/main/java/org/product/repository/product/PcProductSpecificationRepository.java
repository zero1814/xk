package org.product.repository.product;

import org.product.entity.product.PcProductSpecification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface PcProductSpecificationRepository extends BaseRepository<PcProductSpecification, String> {

	@Query(nativeQuery = true, value = "delete from pc_product_specification where product=:product")
	int deleteSpecificationByProduct(@Param("product") String product);

}
