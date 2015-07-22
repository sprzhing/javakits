package com.baidu.phoenix.spring.sope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baidu.phoenix.service.ContactInfoService;

public class Main {
	public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath*:applicationContext.summer.xml");
	public static ClassPathXmlApplicationContext getContext() {
		return context;
	}

	public static void main(String[] argv) {
		ClassPathXmlApplicationContext context = getContext();
		ContactInfoService service = context.getBean(ContactInfoService.class);
		service.insert();
		// System.out.println(VasConst.SPecialCardHeadcount.valueOf("HC2"));
		// System.out.println(VasConst.SPecialCardHeadcount.valueOf("lauzhu"));
	}
}
