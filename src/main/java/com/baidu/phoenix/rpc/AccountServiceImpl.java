/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.rpc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by zhuhongquan on 15/9/21.
 */
public class AccountServiceImpl implements AccountService {
    public List<String> getMsgs() {
        List<String> msgs = new ArrayList<String>();
        msgs.add("hello");
        msgs.add("laozhu");
        return msgs;
    }
}
