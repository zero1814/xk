package org.system.role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.system.SystemCloudApplication;
import org.system.entity.role.ScRole;
import org.system.service.role.IScRoleService;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.result.EntityResult;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = SystemCloudApplication.class)
public class ScRoleTest {

	@Autowired
	public IScRoleService service;

	@Test
	public void getOne() {
		EntityResult<ScRole> result = service.select("SR1107518967339020288");
		ScRole entity = result.getEntity();
		System.out.println(JSON.toJSON(entity));
	}
}
