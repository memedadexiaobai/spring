package com.luban;

import com.luban.entity.User;
import com.luban.service.UserService;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * gradlew :spring-oxm:compileTestJava    成功编译源码
 */
public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring.xml");
		//修改默认类加载器方式1.
//		applicationContext.getBeanFactory().setBeanClassLoader();
		//2.
//		Thread.currentThread().setContextClassLoader();

		applicationContext.getBean("UserService.class");
		UserService userService = applicationContext.getBean(UserService.class);
//		userService.test();

		AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(UserService.class);


//		ProxyFactory factory = new ProxyFactory();
//		factory.setOptimize(true);
//		factory.setTargetClass(UserService.class);
//		factory.addInterface(UserInterface.class);
//		factory.addAdvisor(new MyAdvisor());
//		factory.addAdvice(new AfterReturningAdvice() {
//			@Override
//			public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
//				System.out.println("return");
//			}
//		});
//
//		UserInterface userService = (UserInterface) factory.getProxy();
//		userService.test();
	}
}
