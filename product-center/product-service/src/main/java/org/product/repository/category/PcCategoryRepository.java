package org.product.repository.category;

import java.util.List;

import org.product.entity.category.PcCategory;
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
public interface PcCategoryRepository extends BaseRepository<PcCategory, String> {

	/**
	 * 
	 * 方法: parent <br>
	 * 描述: 查询除了当前分类的其他分类 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午11:13:14
	 * 
	 * @param code
	 * @return
	 */
	@Query(value = "select new PcCategory(code,name) from PcCategory where flagEnabled = 0 and code <>:code order by sort desc")
	List<PcCategory> categoryNotConcatCode(@Param("code") String code);

	/**
	 * 
	 * 方法: categoryAll <br>
	 * 描述: 查询所有分类 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月28日 上午11:13:33
	 * 
	 * @return
	 */
	@Query(value = "select new PcCategory(code,name) from PcCategory where flagEnabled = 0 order by sort desc")
	List<PcCategory> categoryAll();
}
