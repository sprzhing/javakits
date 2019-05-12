/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * 添加水印
 * Created by zhuhongquan on 15/9/17.
 */
@Service
@Aspect
public class WaterMarkAspect {

    @Pointcut("@annotation(waterMarkAnnotation)")
    public void waterMark(WaterMark waterMarkAnnotation){

    }

    @Around("waterMark(waterMarkAnnotation)")
    public void addWaterMark(ProceedingJoinPoint joinPoint, WaterMark waterMarkAnnotation){
        String picUrl = waterMarkAnnotation.iconMark();
        String waterMarkIcon = waterMarkAnnotation.param();
        String transformUrl = "这里已经被替换掉了参数：" + picUrl + ":" + waterMarkIcon;
        String[] params = new String[]{transformUrl};
        try {
            joinPoint.proceed(params);
        } catch (Throwable throwable) {
            throw new RuntimeException("Failed to add watermark.");
        }
    }
}
