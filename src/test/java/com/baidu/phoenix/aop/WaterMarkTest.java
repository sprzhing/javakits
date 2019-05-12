/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.phoenix.aspect.WaterMarkDemo;

/**
 * Created by zhuhongquan on 15/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext.summer.xml")
// 单元测试后事务回滚
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class WaterMarkTest {
    @Autowired
    private WaterMarkDemo demo;
    @Test
    public void testDemo(){
        demo.addWaterMark("watermark...");
    }
}
