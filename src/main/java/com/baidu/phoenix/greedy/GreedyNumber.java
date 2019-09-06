/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
    public static class ValueBean {
        public long min;
        public int index;
    }

    public static void main(String[] args) {
        //一种思路是从删除角度来考虑
        //long result = GetTrimNResultNumber(Arrays.asList(3L, 6L, 8L, 4L, 3L, 2L), 2);
        // 另一种思路从选取角度来考虑
        long result = GetSelectResultNumber(Arrays.asList(8L, 3L, 6L, 8L, 4L, 3L, 2L), 5);
        System.out.println(result);
    }

    public static long GetSelectResultNumber(List<Long> array, int k) {
        if (array.isEmpty() || array.size() < k) {
            throw new RuntimeException("illegal param: " + array.size() + ":" + k);
        }
        int left = array.size() - k;
        List<ValueBean> result = Lists.newArrayList();
        int begin = 0;
        int end = array.size() - left + 1;
        for (int j = 0; j < left; j++) {
            ValueBean b = PickOneNumber(begin, end, array);
            System.out.println(b.min);
            result.add(b);
            begin = b.index + 1;
            end = end + 1;
        }
        long res = 0;
        for (ValueBean bean : result) {
            res = res * 10 + bean.min;
        }
        return res;
    }

    public static ValueBean PickOneNumber(int begin, int end, List<Long> arr) {
        ValueBean bean = new ValueBean();
        bean.min = Integer.MAX_VALUE;
        for (int i = begin; i < end; i++) {
            if (arr.get(i) < bean.min) {
                bean.min = arr.get(i);
                bean.index = i;
            }
        }
        return bean;
    }

    public static long GetTrimNResultNumber(List<Long> array, long k) {
        if (array.isEmpty() || array.size() < k) {
            throw new RuntimeException("illegal param: " + array.size() + ":" + k);
        }
        List<Long> temp = array;
        for (int count = 0; count < k; count++) {
            temp = TrimOneNumberResult(temp);
            System.out.println(temp);
        }
        return ConvertToLong(temp);
    }

    public static List<Long> TrimOneNumberResult(List<Long> array) {
        List<Long> trimResult = Lists.newArrayList();
        for (int cursor = 0; cursor < array.size(); cursor++) {
            if (cursor == array.size() - 1) {
                break;
            }
            if (array.get(cursor) <= array.get(cursor + 1)) {
                trimResult.add(array.get(cursor));
            } else {
                for (int left = cursor + 1; left < array.size(); left++) {
                    trimResult.add(array.get(left));
                }
                break;
            }
        }
        return trimResult;
    }

    public static long ConvertToLong(List<Long> array) {
        if (array.size() == 0) {
            return 0;
        }
        long result = 0;
        for (int begin = 0; begin < array.size(); begin++) {
            result = result * 10 + array.get(begin);
        }
        return result;
    }
}