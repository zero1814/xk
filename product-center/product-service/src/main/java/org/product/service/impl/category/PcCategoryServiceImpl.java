package org.product.service.impl.category;

import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.product.entity.category.PcCategory;
import org.product.entity.category.PcCategoryAttribute;
import org.product.repository.category.PcCategoryRepository;
import org.product.service.category.IPcCategoryService;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.springframework.stereotype.Service;
import org.zero.spring.jpa.BaseEntity;

import zero.commons.basics.ObjectUtil;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.EntityResult;

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

	@Override
	public EntityResult<PcCategory> create(PcCategory entity) {
		Date date = new Date();
		if (entity.getCreateTime() != null) {
			date = entity.getCreateTime();
		}
		if (!entity.getAttributes().isEmpty()) {
			for (PcCategoryAttribute attr : entity.getAttributes()) {
				String code = CodeHelper.getCode(attr.getClass());
				attr.setCode(code);
				attr.setCreateUser(entity.getCreateUser());
				attr.setCreateTime(date);
				attr.setUpdateUser(entity.getCreateUser());
				attr.setUpdateTime(date);
			}
		}
		return super.create(entity);
	}

	public static void main(String[] args) {
		PcCategory entity = new PcCategory();
		Field[] fields = entity.getClass().getDeclaredFields();
		try {
			for (Field f : fields) {
				boolean isExtends = BaseEntity.class.isAssignableFrom(entity.getClass());
				if (isExtends) {
					boolean flag = f.isAnnotationPresent(OneToMany.class);
					boolean flag2 = f.isAnnotationPresent(ManyToOne.class);
					Object obj = f.get(entity);
					if (flag) {
						boolean isExistsCode = ObjectUtil.isExistsFiled("code", obj);
						if (isExistsCode) {
							ObjectUtil.setFieldValueByName("code", CodeHelper.getCode(obj.getClass()), obj);
						}
					} else if (flag2) {

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
