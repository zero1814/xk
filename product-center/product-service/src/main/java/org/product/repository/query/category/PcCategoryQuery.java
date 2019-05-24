package org.product.repository.query.category;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.product.entity.category.PcCategory;
import org.product.repository.category.PcCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PcCategoryQuery {

	@Autowired
	private PcCategoryRepository repository;

	public List<PcCategory> parent(String code) {
		try {
			Specification<PcCategory> spec = new Specification<PcCategory>() {
				private static final long serialVersionUID = 8413983764229608381L;

				@Override
				public Predicate toPredicate(Root<PcCategory> root, CriteriaQuery<?> query,
						CriteriaBuilder criteriaBuilder) {
					if (StringUtils.isNotBlank(code)) {
						query.where(criteriaBuilder.notEqual(root.get("code"), code));
					}
					// 这种方式使用JPA的API设置了查询条件，所以不需要再返回查询条件Predicate给Spring Data Jpa，故最后return null
					return null;
				}
			};
			return repository.findAll(spec, Sort.by(Direction.ASC, "sort"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
