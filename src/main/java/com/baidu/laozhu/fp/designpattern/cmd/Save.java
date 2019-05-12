/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.cmd;

/**
 * Save
 *
 * @author sprzhing
 * @date 16/7/26:06:57
 * @description
 */
public class Save implements Action {
    private final Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    public void perform() {
        editor.save();
    }
}