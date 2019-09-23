/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.Size;

/**
 * ArraySum
 *
 * @author sprzhing
 * @date 2019-09-23:14:35
 * @description
 */
public class ArraySum {
    /**
     * 思路对了，有两个低级错误，一个是carry在每次计算完成没有置位为0；而是while
     * 写成了if，并且10写成0
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{2,7,4}, 181));
    }
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<Integer>();
        int s = K;
        int carry = 0;
        int kSum;
        int aStart = A.length - 1;
        int aFactor;
        while (s >0){
            aFactor = aStart >= 0 ? A[aStart] : 0;
            kSum = s % 10 + carry + aFactor;
            carry = (kSum >= 10) ? (kSum / 10) : 0;
            kSum = (kSum >=10) ?(kSum%10):kSum;
            result.add(kSum);
            s = s / 10;
            aStart--;
        }
        while (aStart>=0){
            kSum = A[aStart] + carry;
            carry = (kSum >=10) ? (kSum / 10): 0;
            kSum = (kSum >=10) ? (kSum % 10) :kSum;
            result.add(kSum);
            aStart--;
        }
        if (carry>0){
            result.add(carry);
        }
        Collections.reverse(result);
        return result;
    }
}