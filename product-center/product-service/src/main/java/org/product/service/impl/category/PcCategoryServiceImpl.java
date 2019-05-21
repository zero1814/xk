package org.product.service.impl.category;

import java.lang.reflect.Field;
import java.util.List;

import org.product.entity.category.PcCategory;
import org.product.repository.category.PcCategoryRepository;
import org.product.service.category.IPcCategoryService;
import org.product.service.impl.FlagEnabledServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.helper.CodeHelper;
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

	public static void main(String[] args) {
		try {
			PcCategory entity = new PcCategory();
			entity.setUid(CodeHelper.getCode(PcCategory.class));
			Field[] fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.getName().equals("name")) {
					field.set(entity, "测试");
				}
			}
			System.out.println(JSON.toJSONString(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataResult<PcCategory> findParent(String code) {
		DataResult<PcCategory> result = new DataResult<PcCategory>();
		try {
			List<PcCategory> list = repository.findParent(code);
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
}
