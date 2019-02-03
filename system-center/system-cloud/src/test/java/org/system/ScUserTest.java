package org.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.system.entity.ScUserInfo;
import org.system.service.IScUserInfoService;

import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = CloudApplication.class)
public class ScUserTest {

	@Autowired
	private IScUserInfoService service;

	@Test
	public void insert() {
		ScUserInfo entity = new ScUserInfo();
		entity.setCode(CodeHelper.getCode("SU"));
		entity.setNickName("测试");
		entity.setPhone("13452993321");
		entity.setEmail("123@127.com");
		entity.setType("1");
		entity.setStatus("2");
		entity.setCreateUser("test");
		service.insert(entity);
		service.insert(entity);
	}
}
