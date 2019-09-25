/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThreeSumOut
 *
 * @author sprzhing
 * @date 2019-09-25:00:40
 * @description
 */
class ThreeSumOut {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len < 3){
            return result;
        }
        Arrays.sort(nums);
        if ((nums[0] < 0 && nums[len - 1]<0) || (nums[0] >0 && nums[len -1] > 0)){
            return result;
        }else if(nums[0] == 0){
            if (len >=3){
                if (nums[0] + nums[1] + nums[2] == 0){
                    List<Integer> hit = new ArrayList<Integer>();
                    hit.add(0);
                    hit.add(0);
                    hit.add(0);
                    result.add(hit);
                    return result;
                }
            }
        }
        int middle = 0;
        for( int i=0; i< len; i++){
            if (nums[i] == 0){
                middle = i;
                break;
            }
            if (nums[i] < 0 && nums[i + 1] > 0){
                middle = i;
                break;
            }
        }
        for (int i = 0;i <= middle;i++){
            for (int j = 0;j<=middle;j++){
                for(int e = len-1;e>middle;e--){
                    if (i != j && (nums[i]+nums[j]+nums[e] == 0)){
                        List<Integer> hit = new ArrayList<Integer>();
                        if(i <=j){
                            hit.add(nums[i]);
                            hit.add(nums[j]);
                        }else{
                            hit.add(nums[j]);
                            hit.add(nums[i]);
                        }

                        hit.add(nums[e]);
                        if(!result.contains(hit)){
                            result.add(hit);
                        }
                    }
                }
            }
        }
        for (int i = len-1;i > middle;i--){
            for (int j = len-1;j>middle;j--){
                for(int e = 0;e<=middle;e++){
                    if (i != j && (nums[i]+nums[j]+nums[e] == 0)){
                        List<Integer> hit = new ArrayList<Integer>();
                        hit.add(nums[e]);
                        if(i <= j){
                            hit.add(nums[i]);
                            hit.add(nums[j]);
                        }else{
                            hit.add(nums[j]);
                            hit.add(nums[i]);
                        }
                        if(!result.contains(hit)){
                            result.add(hit);
                        }
                    }
                }
            }
        }

        for(int i=0; i< middle; i++){
            for (int j= len -1 ;j>middle; j--){
                if (nums[i] + nums[j] + nums[middle] == 0){
                    List<Integer> hit = new ArrayList<Integer>();
                    hit.add(nums[i]);
                    hit.add(nums[middle]);
                    hit.add(nums[j]);
                    if(!result.contains(hit)){
                        result.add(hit);
                    }
                }
            }
        }
        return result;
    }
}