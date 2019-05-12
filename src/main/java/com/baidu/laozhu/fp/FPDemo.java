/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.fp;

import java.util.Arrays;
import java.util.List;

/**
 * FPDemo
 *
 * @author sprzhing
 * @date 16/7/26:07:50
 * @description
 */
public class FPDemo {
    public static void main(String[] args) {
        // 集合并行化的支持
        List<Long> nameList = Arrays.asList(3L, 3L, 45L, 2L, 67L, 999999L);
        Long[] array = (Long[]) nameList.toArray();
        Arrays.parallelSort(array);
        for (Long id : array) {
            System.out.println(id);
        }
        // stream中函数惰性求值和即刻求值
        nameList.stream().mapToInt(Long::intValue).sum();

    }
}