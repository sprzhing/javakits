/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.rpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by zhuhongquan on 15/9/22.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.client.xml");
        AccountService service = (AccountService)ctx.getBean("accountRmiService");
        System.out.println("laozhu" + service.getMsgs());
    }
}
