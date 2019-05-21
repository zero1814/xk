package org.product.repository.category;

import org.product.entity.category.PcCategory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.zero.spring.jpa.BaseRepository;

/**
 * 
 * 类: PcCategoryRepository <br>
 * 描述: 分类数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午3:56:26
 */
public interface PcCategoryRepository extends BaseRepository<PcCategory, String>, JpaSpecificationExecutor<PcCategory> {

}
