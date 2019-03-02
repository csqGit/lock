package com.app.bzpower.util;

import org.junit.Test;

import com.app.bzpower.controller.UserController;
import com.app.bzpower.entity.RequestResult;

public class LockTest {

	@Test
	public void loginTest() {
		UserController user = new UserController();
		RequestResult result = user.userLogin("张三", "zhangsan");
		System.out.println(result);
	}
}
