/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp.designpattern.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Compressor
 *
 * @author sprzhing
 * @date 16/7/26:07:23
 * @description
 */
public class Compressor {
    private final CompressionStrategy strategy;

    public Compressor(CompressionStrategy strategy){
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException{
        try(OutputStream outputStream = new FileOutputStream(outFile)){
            Files.copy(inFile,strategy.compress(outputStream));
        }
    }
}