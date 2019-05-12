/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.strategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * CompressImpl
 *
 * @author sprzhing
 * @date 16/7/26:07:26
 * @description
 */
public class CompressImpl {
    public static void main(String[] args) throws IOException {
        File file = new File("out");
        Path inFile = null; //假设已经作为参数传进来
        Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
        gzipCompressor.compress(inFile, file);
        Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
        zipCompressor.compress(inFile, file);

        // 去除样板化代码类
        Compressor lamdaGzipCompressor = new Compressor(GZIPOutputStream::new);
        lamdaGzipCompressor.compress(inFile, file);
        Compressor lamdaZipCompressor = new Compressor(ZipOutputStream::new);
        lamdaZipCompressor.compress(inFile, file);
    }
}