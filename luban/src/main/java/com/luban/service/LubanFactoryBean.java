package com.luban.service;

import com.luban.dao.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SuppressWarnings("rawtypes")
public class LubanFactoryBean implements FactoryBean { // bean对象--proxyInstance-->UserMapper类型

	private Class mapperInterface;

	public LubanFactoryBean(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {

		Object proxyInstance = Proxy.newProxyInstance(LubanFactoryBean.class.getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// 代理逻辑
				System.out.println(method.getName());
				//

				return null;
			}
		});

		return proxyInstance;
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
