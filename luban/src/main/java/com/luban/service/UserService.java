package com.luban.service;

import com.luban.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Value("true") //通过StringToUserPropertyEditor解析注入
	User test;

	public void propertyEditorTest() {
		System.out.println(test);
	}

	public void test(){
		System.out.println("test");
	}
}
