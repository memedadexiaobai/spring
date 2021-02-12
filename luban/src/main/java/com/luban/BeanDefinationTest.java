package com.luban;

import com.luban.entity.User;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: xingbinjie
 * @Desc:
 * Bean的定义，在Spring中，我们可以如何去定义一个Bean?
 * 1. <bean/>
 * 2. @Bean
 * 3. @Component(@Service,@Controller)
 * 4.通过beanDefinition
 * @Version: 0.0.1
 * @Date: 2021/2/11
 */
public class BeanDefinationTest {

	public static void main(String[] args) {
		// 定义了一个BeanDefinition
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		// 当前Bean对象的类型
		beanDefinition.setBeanClass(User.class);

//		beanDefinition.setScope("prototype"); // 设置作用域
//		beanDefinition.setInitMethodName("init"); // 设置初始化方法
//		beanDefinition.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE); // 设置自动装配模型

		// 将BeanDefinition注册到BeanFactory中
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("user", beanDefinition);
		// 注册别名
//		beanFactory.registerAlias("user", "user1");
		// 注册BeanPostProcessor
//		beanFactory.addBeanPostProcessor(new LubanBeanPostProcessor());

		// 获取Bean
		System.out.println(beanFactory.getBean("user"));
		// 获取Bean对象
//		System.out.println(beanFactory.getBean("user1"));
		// 根据类型获取beanNames
//		System.out.println(beanFactory.getBeanNamesForType(User.class));
	}

}
