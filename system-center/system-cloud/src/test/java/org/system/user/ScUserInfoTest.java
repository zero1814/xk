package org.system.user;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.system.SystemCloudApplication;
import org.system.controller.user.ScUserInfoController;
import org.system.dto.LoginParam;
import org.system.entity.role.ScRole;
import org.system.entity.user.ScUserInfo;
import org.system.entity.user.ScUserStatus;
import org.system.result.user.LoginResult;
import org.system.service.role.IScRoleService;
import org.system.service.user.IScUserInfoService;

import com.alibaba.fastjson.JSON;

import lombok.Getter;
import zero.commons.basics.MD5Util;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = SystemCloudApplication.class)
public class ScUserInfoTest {

	@Autowired
	private IScUserInfoService service;
	@Autowired
	private IScRoleService roleService;
	@Autowired
	private ScUserInfoController controller;

	public void insert() {
		ScUserInfo entity = new ScUserInfo();
		entity.setCreateUser("test");
		entity.setUserName("admin");
		entity.setPassword(MD5Util.md5Hex("000000"));
		entity.setPhone("13422293372");
		entity.setEMail("12321@1321312.com");
		entity.setRealName("管理用户");
		entity.setHeaderPic("dddd");
		ScUserStatus status = new ScUserStatus();
		status.setCode("SUS1117692605543477248");
		entity.setStatus(status);
		DataResult<ScRole> roleResult = roleService.selectAll(null);
		if (roleResult.getCode() == ResultType.SUCCESS) {
			entity.setRoles(roleResult.getData());
		}
		service.insert(entity);
	}

	public void object() {
		ScUserInfo entity = new ScUserInfo();
		entity.setPhone("13422293382");
		entity.setPassword("000000");
		System.out.println("flag = " + entity.getClass().isAnnotationPresent(Getter.class));
		if (entity.getClass().isAnnotationPresent(Getter.class)) {
			Getter getter = entity.getClass().getAnnotation(Getter.class);
			Field[] fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				System.out.println("----------");
				System.out.println(field.getName());
				System.out.println(getter.onMethod());
				System.out.println("--------------");
			}
		}
	}

	@Test
	public void login() {
		LoginParam param = new LoginParam();
		param.setUsername("admin");
		param.setPassword("000000");
		LoginResult result = controller.login(param);
		System.out.println(JSON.toJSON(result));
	}
}
