package com.baidu.phoenix.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.baidu.phoenix.entity.ContactInfo;

@Repository
public class ContactInfoDaoImpl extends HibernateDaoSupport implements
		ContactInfoDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {

		super.setSessionFactory(sessionFactory);
	}

	public void insert(ContactInfo info) {
		Session session = sessionFactory.getCurrentSession();
		if (null == info) {
			ContactInfo entity = new ContactInfo();
			entity.setAderId(1746L);
			entity.setContactName("Hello");
			entity.setContactMail("715426333@qq.com");
			entity.setContactPhone("13519178909");
			session.saveOrUpdate(entity);
		} else {
			session.saveOrUpdate(info);
			session.flush();
		}

	}

}
