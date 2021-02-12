package com.luban;

import com.luban.entity.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @Author: xingbinjie
 * @Desc:
 * BeanDefinitionReader分为几类：
 * AnnotatedBeanDefinitionReader  可以直接把某个类转换为BeanDefinition，并且会解析该类上的注解
 * 注意：它能解析的注解是：@Conditional，@Scope、@Lazy、@Primary、@DependsOn、@Role、@Description
 *
 * XmlBeanDefinitionReader  可以解析<bean/>标签
 *
 * ClassPathBeanDefinitionScanner  这个并不是BeanDefinitionReader，但是它的作用和 BeanDefinitionReader类似，
 * 它可以进行扫描，扫描某个包路径，对扫描到的类进行解析，比如，扫描到的类上如果存在@Component注解，
 * 那么就会把这个类解析为一个BeanDefinition
 * @Version: 0.0.1
 * @Date: 2021/2/11
 */
public class BeanDefinitionReaderTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);

        // 将User.class解析为BeanDefinition
		annotatedBeanDefinitionReader.register(User.class);

		System.out.println(beanFactory.getBean("user"));


		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		int i = xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");

		System.out.println(beanFactory.getBean("user"));
	}
}
