package org.product.service.impl.category;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.product.entity.category.PcCategory;
import org.product.entity.category.PcCategoryAttribute;
import org.product.entity.category.PcCategorySpecification;
import org.product.repository.category.PcCategoryAttributeRepository;
import org.product.repository.category.PcCategoryRepository;
import org.product.repository.category.PcCategorySpecificationRepository;
import org.product.service.category.IPcCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import zero.commons.basics.StringUtils;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.PageResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: PcCategoryServiceImpl <br>
 * 描述: 分类业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2019年4月29日 下午5:21:09
 */
@Service
@Slf4j
public class PcCategoryServiceImpl extends BaseServiceImpl<PcCategory, String, PcCategoryRepository>
		implements IPcCategoryService {

	@Autowired
	private PcCategoryRepository repository;
	@Autowired
	private PcCategorySpecificationRepository specificationRepository;
	@Autowired
	private PcCategoryAttributeRepository attributeRepository;

	@Autowired
	private EntityManager em;

	public EntityResult<PcCategory> create(PcCategory entity) {
		EntityResult<PcCategory> result = new EntityResult<PcCategory>();
		try {
			boolean flag = uniqueValidate(entity.getName());
			if (flag) {
				result.setCode(ResultType.ERROR);
				result.setMessage("分类名称已存在");
				return result;
			}
			String categoryCode = CodeHelper.getCode(entity.getClass());
			Date date = new Date();
			entity.setUid(CodeHelper.getUUID());
			entity.setCode(categoryCode);
			entity.setUpdateUser(entity.getCreateUser());
			entity.setCreateTime(date);
			entity.setUpdateTime(date);
			if (entity.getSepcList().isEmpty()) {
				result.setCode(ResultType.ERROR);
				result.setMessage("分类规格参数不能为空");
				return result;
			}
			if (entity.getAttributeList().isEmpty()) {
				result.setCode(ResultType.ERROR);
				result.setMessage("分类属性不能为空");
				return result;
			}
			List<PcCategorySpecification> specList = validateSpec(categoryCode, entity.getSepcList());
			for (PcCategorySpecification spec : specList) {
				spec.setUid(CodeHelper.getUUID());
				spec.setCode(CodeHelper.getCode(spec.getClass()));
			}
			entity.setSepcList(specList);
			List<PcCategoryAttribute> attributeList = validateAtrribute(categoryCode, entity.getAttributeList());
			for (PcCategoryAttribute attr : attributeList) {
				attr.setUid(CodeHelper.getUUID());
				attr.setCode(CodeHelper.getCode(attr.getClass()));
			}
			entity.setAttributeList(attributeList);
			PcCategory category = repository.saveAndFlush(entity);
			result.setEntity(category);
			result.setMessage("保存成功");
			result.setCode(ResultType.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("保存报错");
			result.setCode(ResultType.ERROR);
		}
		return result;
	}

	@Override
	public DataResult<PcCategory> findParent(String code) {
		DataResult<PcCategory> result = new DataResult<PcCategory>();
		try {
			List<PcCategory> list = null;
			if (StringUtils.isNotBlank(code)) {
				list = repository.categoryNotConcatCode(code);
			} else {
				list = repository.categoryAll();
			}
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

	@SuppressWarnings("unchecked")
	@Override
	public PageResult<PcCategory> page(@Param("category") PcCategory entity) {
		PageResult<PcCategory> result = new PageResult<PcCategory>();
		try {
			StringBuffer sql = new StringBuffer(
					"select new PcCategory(code,name,icon,flagEnabled,sort) from PcCategory where 1=1 ");
			if (StringUtils.isNotBlank(entity.getName())) {
				sql.append("and name like '%").append(entity.getName()).append("%' ");
			} else if (entity.getFlagEnabled() != null) {
				sql.append("and flagEnabled=").append(entity.getFlagEnabled());
			}
			Query query = em.createQuery(sql.toString());
			int total = query.getResultList().size();
			// 设置分页参数
			int start = (entity.getPage() - 1) * entity.getSize();
			query.setFirstResult(start);
			query.setMaxResults(entity.getSize());
			List<PcCategory> list = query.getResultList();
			result.setData(list);
			result.setTotal(Long.valueOf(total));
			result.setMessage("查询成功");
			result.setCode(ResultType.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("查询报错");
			result.setCode(ResultType.ERROR);
		}
		return result;
	}

	@Override
	public DataResult<PcCategorySpecification> getSpecifications(String category) {
		DataResult<PcCategorySpecification> result = new DataResult<PcCategorySpecification>();
		log.info("根据分类编码查询分类规格参数,category=" + category);
		try {
			List<PcCategorySpecification> list = specificationRepository.getCategorySpecifications(category);
			result.setCode(ResultType.SUCCESS);
			result.setData(list);
			result.setMessage("查询成功");
		} catch (Exception e) {
			log.error("根据分类编码查询分类规格参数报错：");
			log.error(e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("查询失败");
		}
		return result;
	}

	@Override
	public DataResult<PcCategoryAttribute> getAttributes(String category) {
		DataResult<PcCategoryAttribute> result = new DataResult<PcCategoryAttribute>();
		log.info("根据分类编码查询分类规格参数,category=" + category);
		try {
			List<PcCategoryAttribute> list = attributeRepository.getCategoryAttributes(category);
			result.setCode(ResultType.SUCCESS);
			result.setData(list);
			result.setMessage("查询成功");
		} catch (Exception e) {
			log.error("根据分类编码查询分类规格参数报错：");
			log.error(e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("查询失败");
		}
		return result;
	}

	/**
	 * 
	 * 方法: uniqueValidate <br>
	 * 描述: 验证是否名称已存在 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月31日 上午10:43:40
	 * 
	 * @param name
	 * @return
	 */
	private boolean uniqueValidate(String name) {
		PcCategory entity = new PcCategory();
		entity.setName(name);
		Example<PcCategory> example = Example.of(entity);
		if (repository.findOne(example).isPresent()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 方法: validateSpec <br>
	 * 描述: 整理参数列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月31日 上午11:06:02
	 * 
	 * @param category
	 * @param list
	 * @return
	 */
	private List<PcCategorySpecification> validateSpec(String category, List<PcCategorySpecification> list) {
		// 页面传入的分类参数列表
		List<PcCategorySpecification> result = new ArrayList<PcCategorySpecification>();
		// 已存在的分类参数列表
		List<PcCategorySpecification> data = specificationRepository.getCategorySpecifications(category);
		if (data.isEmpty()) {
			return list;
		}
		for (PcCategorySpecification spec : list) {
			for (PcCategorySpecification dbSepc : data) {
				if (!StringUtils.equals(spec.getName(), dbSepc.getName())) {
					result.add(spec);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * 方法: validateAtrribute <br>
	 * 描述: 整理属性列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年5月31日 上午11:06:13
	 * 
	 * @param category
	 * @param list
	 * @return
	 */
	private List<PcCategoryAttribute> validateAtrribute(String category, List<PcCategoryAttribute> list) {
		// 页面传入的分类属性列表
		List<PcCategoryAttribute> result = new ArrayList<PcCategoryAttribute>();
		// 已存在的分类属性列表
		List<PcCategoryAttribute> data = attributeRepository.getCategoryAttributes(category);
		if (data.isEmpty()) {
			return list;
		}
		for (PcCategoryAttribute attr : list) {
			for (PcCategoryAttribute dbAttr : data) {
				if (!StringUtils.equals(attr.getName(), dbAttr.getName())) {
					// 如果分类属性没有存在，新增
					result.add(attr);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * 方法: categoryData <br>
	 * 
	 * @return
	 * @see org.product.service.category.IPcCategoryService#categoryData()
	 */
	@Override
	public DataResult<PcCategory> categoryData() {
		DataResult<PcCategory> result = new DataResult<PcCategory>();
		try {
			List<PcCategory> list = repository.categoryAll();
			result.setData(list);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("查询报错");
		}
		return result;
	}
}
