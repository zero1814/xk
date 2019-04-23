package org.system.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.system.SystemCloudApplication;
import org.system.controller.user.ScUserStatusController;
import org.system.entity.user.ScUserStatus;
import org.system.service.user.IScUserStatusService;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.result.DataResult;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = SystemCloudApplication.class)
public class ScUserStatusTest {

	@Autowired
	private IScUserStatusService service;

	@Autowired
	private ScUserStatusController controller;
	
	@Test
	public void insert() {
		String[] status = new String[] { "正常", "已注销", "已删除", "已冻结", "已过期", "未验证" };
		for (String str : status) {
			ScUserStatus entity = new ScUserStatus();
			entity.setName(str);
			entity.setCreateUser("insert");
			service.insert(entity);
		}
	}

	@Test
	public void all() {
//		DataResult<ScUserStatus> result = controller.selectAll(new ScUserStatus());
		DataResult<ScUserStatus> result = controller.selectAll(null);
		System.out.println(JSON.toJSONString(result));
	}
}
