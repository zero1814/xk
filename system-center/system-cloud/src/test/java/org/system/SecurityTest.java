package org.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.system.controller.user.ScUserInfoController;

import com.alibaba.fastjson.JSON;

import zero.commons.basics.result.WebResult;

@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = SystemCloudApplication.class)
public class SecurityTest {

	@Autowired
	private ScUserInfoController controller;

	@Test
	public void test() {
		WebResult result = controller.select("123");
		System.out.println(JSON.toJSON(result));
	}
}
