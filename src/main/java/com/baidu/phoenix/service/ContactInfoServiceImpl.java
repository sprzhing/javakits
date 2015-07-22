package com.baidu.phoenix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.phoenix.dao.ContactInfoDao;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {
	@Autowired
	private ContactInfoDao dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void insert() {
		dao.insert(null);
	}

}
