/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * Macro
 *
 * @author sprzhing
 * @date 16/7/26:07:01
 * @description
 */
public class Macro {
    private List<Action> actions;

    public Macro() {
        actions = new ArrayList<Action>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }

    public static void main(String[] args) {
        // 假设Gui已经有个editor
        final Editor editor = new Editor() {
            @Override
            public void save() {
                System.out.println("editor save");
            }

            @Override
            public void open() {
                System.out.println("editor open");
            }

            @Override
            public void close() {
                System.out.println("editor close");
            }
        };
        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));
        macro.run();
        // lamda方式,命令者对象删除,lamda方法引用更直观
        Macro lamdaMacro = new Macro();
        lamdaMacro.record(editor::open);
        lamdaMacro.record(editor::save);
        lamdaMacro.record(editor::close);
        lamdaMacro.run();
    }
}