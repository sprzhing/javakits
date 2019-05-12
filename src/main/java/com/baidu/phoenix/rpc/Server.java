/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.rpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Created by zhuhongquan on 15/9/22.
 */
public class Server {
    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.summer.xml");
        RmiServiceExporter obj = (RmiServiceExporter)ctx.getBean("RmiServiceExporter");
    }
}
