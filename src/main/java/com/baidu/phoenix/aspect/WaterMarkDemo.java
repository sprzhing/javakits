/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.aspect;

import org.springframework.stereotype.Service;

/**
 * Created by zhuhongquan on 15/9/17.
 */
@Service
public class WaterMarkDemo {
    @WaterMark(iconMark = "http://www.adg.com/2.jpg",param = "laozhu")
    public void addWaterMark(String url){
        System.out.println(url);
    }
}
