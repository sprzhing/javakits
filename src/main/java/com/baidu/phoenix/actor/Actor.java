/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.actor;

/**
 * Created by zhuhongquan on 16/1/26.
 */
public abstract class Actor<T> implements IActor {
    private ActorContext context;

    protected Actor() {
        this.context = new ActorContext(this);
    }

    protected abstract void receive(T message);

    protected void exit() {
    }

    public void post(T message) {
    }

    public ActorContext context(){
        return context;
    }
}
