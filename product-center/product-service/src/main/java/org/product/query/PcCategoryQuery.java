package org.product.query;

import java.util.List;

import org.product.entity.category.PcCategory;
import org.product.repository.category.PcCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

/**
 * 
 * 类: PcCategoryQuery <br>
 * 描述: <br>
 * Matching介绍<br>
 * Matching 生成的语句 说明<br>
 * DEFAULT (case-sensitive) firstname = ?0 默认（大小写敏感）<br>
 * DEFAULT (case-insensitive) LOWER(firstname) = LOWER(?0) 默认（忽略大小写）<br>
 * EXACT (case-sensitive) firstname = ?0 精确匹配（大小写敏感）<br>
 * EXACT (case-insensitive) LOWER(firstname) = LOWER(?0) 精确匹配（忽略大小写）<br>
 * STARTING (case-sensitive) firstname like ?0 + ‘%’ 前缀匹配（大小写敏感）<br>
 * STARTING (case-insensitive) LOWER(firstname) like LOWER(?0) + ‘%’
 * 前缀匹配（忽略大小写）<br>
 * ENDING (case-sensitive) firstname like ‘%’ + ?0 后缀匹配（大小写敏感）<br>
 * ENDING (case-insensitive) LOWER(firstname) like ‘%’ + LOWER(?0)
 * 后缀匹配（忽略大小写）<br>
 * CONTAINING (case-sensitive) firstname like ‘%’ + ?0 + ‘%’ 模糊查询（大小写敏感）<br>
 * CONTAINING (case-insensitive) LOWER(firstname) like ‘%’ + LOWER(?0) + ‘%’
 * 模糊查询（忽略大小写）<br>
 * 作者: zhy<br>
 * 时间: 2019年5月24日 上午11:30:52
 */
@Component
public class PcCategoryQuery {

	@Autowired
	private PcCategoryRepository repository;

	public List<PcCategory> list(PcCategory entity) {
		ExampleMatcher matcher = ExampleMatcher.matching();
		// if (StringUtils.isNotBlank(entity.getName())) {
		// matcher.withMatcher("name", GenericPropertyMatchers.contains());
		// } else if (entity.getFlagEnabled() != null) {
		// matcher.withMatcher("flagEnabled", GenericPropertyMatchers.exact());
		// }
		matcher.withIgnorePaths("attributes,children,params");
		Example<PcCategory> example = Example.of(entity, matcher);
		List<PcCategory> list = repository.findAll(example);
		return list;
	}
}
