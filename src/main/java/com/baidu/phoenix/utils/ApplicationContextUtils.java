package com.baidu.phoenix.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * An Utility to get {@code ApplicationContext} and {@code Bean} explicitly. You
 * should add below section in ApplicationContext.xml to enable this utility
 * <p>
 * &lt;bean class="com.baidu.phoenix.utils.ApplicationContextUtils"
 * lazy-init="false"/&gt;
 * 
 */
public class ApplicationContextUtils implements ApplicationContextAware {
	private static ApplicationContext context;

	// Spring在初始化时，会调用实现了ApplicationContextAware接口类中的setApplicationContext方法注入上下文
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		ApplicationContextUtils.context = context;
	}
	public static ApplicationContext getContext(){
		return ApplicationContextUtils.context;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T getBeanOfType(Class<T> type) {
		Map beans = context.getBeansOfType(type);
		if (beans == null || beans.isEmpty() || beans.size() > 1) {
			throw new RuntimeException(
					"Should find only one bean of given type " + type
							+ ", but find " + beans + " actually");
		}
		return (T) beans.values().iterator().next();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) context.getBean(name);
	}
}
