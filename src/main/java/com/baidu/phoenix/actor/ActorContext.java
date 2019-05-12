/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.actor;

/**
 * Created by zhuhongquan on 16/1/26.
 */
public class ActorContext {
    public static final int WAITING = 0;
    public static final int EXECUTING = 1;
    public static final int EXITED = 2;
    public int m_status;

    private IActor actor;

    public ActorContext(IActor actor) {
        this.actor = actor;
    }

    public IActor getActor() {
        return actor;
    }
}
