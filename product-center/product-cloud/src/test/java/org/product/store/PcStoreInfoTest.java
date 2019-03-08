package org.product.store;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.product.ProductCloudApplication;
import org.product.entity.store.PcStoreInfo;
import org.product.repository.store.PcStoreInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.ObjectUtil;
import zero.commons.basics.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = ProductCloudApplication.class)
public class PcStoreInfoTest {

	@Autowired
	private PcStoreInfoRepository repository;

	@Test
	public void find() {
		PcStoreInfo entity = new PcStoreInfo();
		entity.setName("d");
		ExampleMatcher matcher = ExampleMatcher.matching();
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object value = ObjectUtil.getFieldValueByName(field.getName(), entity);
			if (value != null && StringUtils.equals(field.getType().toString(), "class java.lang.String")) {
				matcher = matcher.withMatcher(field.getName(), ExampleMatcher.GenericPropertyMatchers.contains());
			}
		}
		Example<PcStoreInfo> example = Example.of(entity, matcher);
		List<PcStoreInfo> list = repository.findAll(example);
		System.out.println(JSON.toJSON(list));
	}
}
