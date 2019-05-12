/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.observer;

/**
 * ObserverImpl
 *
 * @author sprzhing
 * @date 16/7/26:07:38
 * @description
 */
public class ObserverImpl {
    public static void main(String[] args) {
        Moon moon = new Moon();
        moon.startSpying(name -> {
            if (name.contains("zhiyuan")) {
                System.out.println("we made him!!!");
            }
        });

        moon.startSpying(name -> {
            if (name.contains("hongquan")) {
                System.out.println("hello,good!!!");
            }
        });

        moon.land("laozhu");
        moon.land("hongquan");
        moon.land("zhiyuan");
    }
}