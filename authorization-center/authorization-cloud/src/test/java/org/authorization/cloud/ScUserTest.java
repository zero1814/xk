package org.authorization.cloud;

import org.authorization.cloud.entity.ScUser;
import org.authorization.cloud.service.IScUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import zero.commons.basics.helper.CodeHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OauthApplication.class)
public class ScUserTest {

	@Autowired
	private IScUserService service;

	@Test
	public void create() {
		ScUser user = new ScUser();
		user.setCode(CodeHelper.getCode(ScUser.class));
		user.setUid(CodeHelper.getUUID());
		user.setUsername("admin");
		user.setPassword("$10$Dajbb5SgOSjtPDjR4QtUMeqHjHQNketM19Rv4vFoZSHaKtCJwuO7S");
		service.create(user);
	}
}
