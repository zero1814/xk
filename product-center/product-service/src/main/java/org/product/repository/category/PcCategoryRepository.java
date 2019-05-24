package org.product.repository.category;

import java.util.List;

import org.product.entity.category.PcCategory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcCategoryRepository <br>
 * 描述: 分类数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:56:26
 */
public interface PcCategoryRepository extends BaseRepository<PcCategory, String>, JpaSpecificationExecutor<PcCategory> {

	@Query(value = "select new PcCategory(code,name) from PcCategory where flagEnabled = 0 and code <>:code")
	List<PcCategory> parent(@Param("code") String code);
}
