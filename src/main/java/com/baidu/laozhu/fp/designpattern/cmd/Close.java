/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.cmd;

/**
 * Close
 *
 * @author sprzhing
 * @date 16/7/26:07:00
 * @description
 */
public class Close implements Action {
    private final Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }

    public void perform() {
        editor.close();
    }
}