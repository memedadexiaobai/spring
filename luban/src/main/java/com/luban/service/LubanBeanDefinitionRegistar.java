package com.luban.service;

import com.luban.dao.OrderMapper;
import com.luban.dao.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class LubanBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

		//扫描

		List<Class> mapperList = new ArrayList<>();
		mapperList.add(UserMapper.class);
		mapperList.add(OrderMapper.class);


		for (Class mapper: mapperList){
			AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
			beanDefinition.setBeanClass(LubanFactoryBean.class);
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);

			registry.registerBeanDefinition(mapper.getName(), beanDefinition);
		}

	}
}
