package org.product.repository.category;

import java.util.List;

import org.product.entity.category.PcCategoryAttribute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

public interface PcCategoryAttributeRepository extends BaseRepository<PcCategoryAttribute, String> {

	@Query("select new PcCategoryAttribute(code,name,value,sort) from PcCategorySpecification where category=:category order by sort desc")
	List<PcCategoryAttribute> getCategoryAttributes(@Param("category") String category);
}
