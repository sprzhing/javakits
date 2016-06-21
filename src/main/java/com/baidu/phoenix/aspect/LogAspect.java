/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.baidu.phoenix.entity.ContactInfo;

/**
 * Created by zhuhongquan on 15/9/16.
 */
@Service
@Aspect // 切面
public class LogAspect {
    // 切点
    @Pointcut(value = "execution(* com.baidu.phoenix.dao.ContactInfoDaoImpl.insert(com.baidu.phoenix.entity.ContactInfo)) && "
            + "args(content)")
    public void insertion(ContactInfo content) {

    }
    // advise通知
    @Before("insertion(content)")
    public void printTips(ContactInfo content) {
        System.out.println("Asp: begin to insert:" + content.toString());
    }

    @After("insertion(content)")
    public void printEnds(ContactInfo content) {
        System.out.println("Asp: successfully insert contents:" + content.toString());
    }

    @Around("insertion(content)")
    public void watchInsert(ProceedingJoinPoint joinPoint, ContactInfo content) {
        System.out.println("Is really inserting:" + content.toString());
        try {
            joinPoint.proceed();
            System.out.println("inserted finished." + content.toString());
        } catch (Throwable throwable) {
            System.out.println("failed to insert contents:" + content.toString());
        }

    }

}
