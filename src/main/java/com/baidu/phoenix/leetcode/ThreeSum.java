/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * ThreeSum
 *
 * @author sprzhing
 * @date 2019-09-25:00:41
 * @description
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> existSet = new HashSet<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                while (begin < end) {
                    if ((nums[i] + nums[begin] + nums[end]) > 0) {
                        end--;
                    } else if ((nums[i] + nums[begin] + nums[end]) < 0) {
                        begin++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[begin]);
                        temp.add(nums[end]);
                        Boolean exist = false;
                        String key = "" + nums[i] + nums[begin] + nums[end];
                        if (!existSet.contains(key)) {
                            result.add(temp);
                            existSet.add(key);
                        }
                        begin++;
                        end--;
                    }
                }
            }
        }
        return result;
    }
}