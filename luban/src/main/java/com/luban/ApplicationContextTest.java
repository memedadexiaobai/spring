package com.luban;

import com.luban.ConversionService.StringToUserConverter;
import com.luban.PropertyEditor.StringToUserPropertyEditor;
import com.luban.entity.User;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

/**
 * @Author: xingbinjie
 * @Desc:
 * @Version: 0.0.1
 * @Date: 2021/2/12
 */
public class ApplicationContextTest {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

		//1.ApplicationContext支持国际化 可以注入bean作为MessageSource来使用
		annotationConfigApplicationContext.getMessage("test", null, new Locale("en_CN"));

		//2.ApplicationContext支持资源加载 这个功能用到了策略模式。
		Resource resource = annotationConfigApplicationContext.getResource("E:\\idea_workspace\\Github\\spring-framework-5.2.4\\luban\\src\\main\\java\\com\\luban\\entity\\User.java");
		System.out.println(resource.contentLength());

		Resource resource1 = annotationConfigApplicationContext.getResource("classpath:com/luban/entity/User.class");
		System.out.println(resource1.contentLength());

		Resource[] resources = annotationConfigApplicationContext.getResources("classpath:com/luban/service/*.class");
		for (Resource resource2 : resources) {
			System.out.println(resource2.contentLength());
		}

		//3. AnnotationConfigApplicationContext可以获取运行时环境 ApplicationContext不支持
		// 获取JVM所允许的操作系统的环境
		annotationConfigApplicationContext.getEnvironment().getSystemEnvironment();

		// 获取JVM本身的一些属性，包括-D所设置的
		annotationConfigApplicationContext.getEnvironment().getSystemProperties();

		// 还可以直接获取某个环境或properties文件中的属性 这个可以通过外部指定  程序启动时候进行使用
		annotationConfigApplicationContext.getEnvironment().getProperty("lubanyyy");

		//还可以使用@PropertySource("classpath:application.properties")来使得某个properties文件中的参数添加到运行时环境中

		//4.AnnotationConfigApplicationContext支持发布事件
		annotationConfigApplicationContext.publishEvent("kkk");

		//5.AnnotationConfigApplicationContext支持类型转换 得注入PropertyEditor
		StringToUserPropertyEditor propertyEditor = new StringToUserPropertyEditor();
		propertyEditor.setAsText("1");
		User value = (User) propertyEditor.getValue();
		System.out.println("value" + value);

		DefaultConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new StringToUserConverter());
		User value1 = conversionService.convert("1", User.class);
		System.out.println("value1" + value1);

		//TypeConverter整合了PropertyEditor和ConversionService的功能，是Spring内部用的
		SimpleTypeConverter typeConverter = new SimpleTypeConverter();
		typeConverter.registerCustomEditor(User.class, new StringToUserPropertyEditor());
		//typeConverter.setConversionService(conversionService);
		User value2 = typeConverter.convertIfNecessary("1", User.class);
		System.out.println("value2" + value2);

		/**
		 * BeanPostProcessor Bean的后置处理器，可以在创建每个Bean的过程中进行干涉，是属于BeanFactory中一个属性
		 *
		 * BeanFactoryPostProcessor Bean工厂的后置处理器，是属于ApplicationContext中的一个属性，
		 * 是ApplicationContext在实例化一个BeanFactory后，可以利用BeanFactoryPostProcessor继续处理BeanFactory。
		 * 程序员可以通过BeanFactoryPostProcessor间接的设置BeanFactory，比如上文中的 CustomEditorConfigurer 就是一个BeanFactoryPostProcessor，
		 * 我们可以通过它向BeanFactory中添加自定义的PropertyEditor。
		 *
		 *
		 * FactoryBean
		 * 允许程序员自定义一个对象通过FactoryBean间接的放到Spring容器中成为一个Bean。
		 * 那么它和 @Bean的区别是什么？因为 @Bean也可以自定义一个对象，让这个对象成为一个Bean。
		 * 区别在于利用FactoryBean可以更加强大，因为你通过定义一个XxFactoryBean的类，可以再去实现Spring中的其他接口，
		 * 比如如果你实现了BeanFactoryAware接口，那么你可以在你的XxFactoryBean中获取到Bean工厂，从而使用Bean工厂做更多你想做的，而@Bean则不行。
		 */
	}

}
