package org.product.service.impl.category;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.product.entity.category.PcCategory;
import org.product.repository.category.PcCategoryRepository;
import org.product.service.category.IPcCategoryService;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcCategoryServiceImpl <br>
 * 描述: 分类业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:09
 */
@Service
public class PcCategoryServiceImpl extends FlagEnabledServiceImpl<PcCategory, String, PcCategoryRepository>
		implements IPcCategoryService {

	@Autowired
	private PcCategoryRepository repository;

	@Override
	public DataResult<PcCategory> findParent(String code) {
		DataResult<PcCategory> result = new DataResult<PcCategory>();
		try {
			List<PcCategory> list = parent(code);
			if (list.isEmpty()) {
				result.setCode(ResultType.NULL);
				result.setMessage("查询列表为空");
				return result;
			}
			result.setCode(ResultType.SUCCESS);
			result.setData(list);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询可选父级分类报错");
		}
		return result;
	}

	private List<PcCategory> parent(String code) {
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
			return repository.findAll(spec,Sort.by("createTime desc"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
