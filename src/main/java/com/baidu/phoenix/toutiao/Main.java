/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.toutiao;

/**
 * Main
 *
 * @author sprzhing
 * @date 2018/8/6:23:34
 * @description
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    private static Gson GSON = new GsonBuilder().create();
    public static void main(String[] args){
        List<Integer> testArray = Arrays.asList(1,2,3);
        System.out.println(GSON.toJson(slice(testArray.toArray(new Integer[0]),0,3,2)));
        // System.out.println(slice(testArray.toArray(),0,3,1));
        // System.out.println(slice(testArray.toArray(),0,100,1));
        // System.out.println(slice(testArray.toArray(),-3,-1,1));
        // System.out.println(slice(testArray.toArray(),2,0,-1));
        // System.out.println(slice(testArray.toArray(),-100,100,2));
    }

    public static Integer[] slice(Integer[] array, int begin, int end, int step){
        List<Integer> list = new ArrayList<>();
        if(null == array || array.length == 0){
            return list.toArray(new Integer[0]);
        }
        int lenth = array.length;
        int leftBound = - lenth;
        int rightBound = lenth - 1;
        if(begin < leftBound){
            begin = leftBound;
        }
        if(end > rightBound){
            end = rightBound;
        }
        if((step > 0 && (begin > end)) || (step <0 && (begin < end))){
            return list.toArray(new Integer[0]);
        }
        begin = begin % lenth;
        end = end % lenth;
        if(step > 0){
            for (int i = begin; i < end; i += step){
                list.add(array[i]);
            }
        }else if (step <0){
            for(int i = end; i < begin; i+= step){
                list.add(array[i]);
            }
        }else{
            list.add(array[begin]);
        }
        return list.toArray(new Integer[0]);
    }
}