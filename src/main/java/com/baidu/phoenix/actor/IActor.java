/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.actor;

/**
 * 通用的actor接口
 * Created by zhuhongquan on 16/1/26.
 */
public interface IActor {
    /**
     * excute and handle msg
     */
    void excute();

    /**
     * check is exist or not
     * @return
     */
    boolean isExisted();

    /**
     * get msg count
     * @return
     */
    int msgCount();

    /**
     * get actor context
     * @return
     */
    ActorContext context();
}
