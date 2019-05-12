/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.cmd;

/**
 * Open
 *
 * @author sprzhing
 * @date 16/7/26:06:59
 * @description
 */
public class Open implements Action {
    private final Editor editor;

    public Open(Editor editor){
        this.editor = editor;
    }
    public void perform() {
        editor.open();
    }
}