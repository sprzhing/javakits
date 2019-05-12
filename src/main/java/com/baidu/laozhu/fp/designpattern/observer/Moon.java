/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Moon
 *
 * @author sprzhing
 * @date 16/7/26:07:36
 * @description
 */
public class Moon {
    private final List<LandingObserver> observers = new ArrayList<>();

    public void land(String name) {
        for (LandingObserver observer : observers) {
            observer.observeLanding(name);
        }
    }

    public void startSpying(LandingObserver observer) {
        observers.add(observer);
    }
}