package com.baidu.phoenix.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.phoenix.entity.ContactInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext.summer.xml")
// 单元测试后事务回滚
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class ContactInfoDaoTest {
	@Autowired
	private ContactInfoDao dao;

	@Test
	@Transactional
	public void testContactInfo() {
		ContactInfo info = new ContactInfo();
		info.setAderId(3333333L);
		info.setContactName("junit");
		info.setContactMail("2222222@qq.com");
		info.setContactPhone("18916970189");
		System.out.println("laozhu");
		dao.insert(info);
		System.out.println("laozhu");
	}
}
