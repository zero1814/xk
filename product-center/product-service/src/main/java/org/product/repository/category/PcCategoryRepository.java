package org.product.repository.category;

import java.util.List;

import org.product.entity.category.PcCategory;
import org.springframework.data.jpa.repository.Query;
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
	 * 方法: findParent <br>
	 * 描述: 查询可选的父级分类 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月21日 上午8:45:29
	 * 
	 * @param code
	 * @return
	 */
	@Query("select code,name from PcCategory where flagEnabled = 0 AND code <> ?1")
	List<PcCategory> findParent(String code);
}
