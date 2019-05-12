/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.rpc;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.phoenix.utils.ApplicationContextUtils;

/**
 * Created by zhuhongquan on 15/9/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext.summer.xml")
// 单元测试后事务回滚
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Ignore
public class RpcTest  {
    private AccountService accountService;

//    @Resource(name = "messageHService")
//    private MessageSendService sendHessionService;

    @Test
    public void testRmiService(){
        accountService = ApplicationContextUtils.getBean("accountRmiService");
        System.out.println("laozhu Rmi:" + accountService.getMsgs());
    }

//    @Test
//    public void testHessianService(){
//        System.out.println("laozhu Hessian:" + sendHessionService.getMsgs());
//    }
}
