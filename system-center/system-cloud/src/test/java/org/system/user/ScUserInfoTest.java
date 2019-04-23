package org.system.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.system.SystemCloudApplication;
import org.system.entity.role.ScRole;
import org.system.entity.user.ScUserInfo;
import org.system.entity.user.ScUserStatus;
import org.system.service.role.IScRoleService;
import org.system.service.user.IScUserInfoService;

import zero.commons.basics.MD5Util;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = SystemCloudApplication.class)
public class ScUserInfoTest {

	@Autowired
	private IScUserInfoService service;
	@Autowired
	private IScRoleService roleService;
	
	@Test
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
		if(roleResult.getCode() == ResultType.SUCCESS) {
			entity.setRoles(roleResult.getData());
		}
		service.insert(entity);
	}
}
