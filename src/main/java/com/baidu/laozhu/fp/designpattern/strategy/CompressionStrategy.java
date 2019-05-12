/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 压缩算法
 * Created by zhuhongquan on 16/7/26.
 */
public interface CompressionStrategy {
    OutputStream compress(OutputStream data) throws IOException;
}
