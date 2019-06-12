package org.product.repository.category;

import java.util.List;

import org.product.entity.category.PcCategorySpecification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface PcCategorySpecificationRepository extends BaseRepository<PcCategorySpecification, String> {

	@Query("select new PcCategorySpecification(code,name,defaultValue,sort) from PcCategorySpecification where category=:category order by createTime desc")
	List<PcCategorySpecification> getCategorySpecifications(@Param("category") String category);
}