/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.greedy;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * GreedyNumber
 *
 * @author sprzhing
 * @date 2019-08-25:16:31
 * @description
 */
public class GreedyNumber {
    public static void main(String[] args) {
        long result = GetTrimNResultNumber(Arrays.asList(3L, 6L, 8L, 4L, 3L, 2L), 2);
        System.out.println(result);
    }

    public static long GetTrimNResultNumber(List<Long> array, long k) {
        if (array.isEmpty() || array.size() < k) {
            throw new RuntimeException("illegal param: " + array.size() + ":" + k);
        }
        List<Long> temp = array;
        for (int count= 0; count < k; count ++){
            temp = TrimOneNumberResult(temp);
            System.out.println(temp);
        }
        return ConvertToLong(temp);
    }
    public static List<Long> TrimOneNumberResult(List<Long> array){
        List<Long> trimResult = Lists.newArrayList();
        for(int cursor = 0; cursor < array.size(); cursor++){
            if(cursor == array.size() - 1){
                break;
            }
            if (array.get(cursor) <= array.get(cursor + 1)){
                trimResult.add(array.get(cursor));
            }else {
                for (int left = cursor + 1; left < array.size(); left++){
                       trimResult.add(array.get(left));
                }
                break;
            }
        }
        return trimResult;
    }

    public static long ConvertToLong(List<Long> array){
        if(array.size() == 0){
            return 0;
        }
        long result = 0;
        for (int begin=0; begin < array.size(); begin++){
            result = result * 10 + array.get(begin);
        }
        return result;
    }
}