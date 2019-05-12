/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.cmd;

/**
 * Editor
 *
 * @author sprzhing
 * @date 16/7/26:06:52
 * @description
 */
public interface Editor {
    void save();
    void open();
    void close();
}