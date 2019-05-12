/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * GzipCompressionStrategy
 *
 * @author sprzhing
 * @date 16/7/26:07:21
 * @description
 */
public class GzipCompressionStrategy implements CompressionStrategy {
    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new GZIPOutputStream(data);
    }
}