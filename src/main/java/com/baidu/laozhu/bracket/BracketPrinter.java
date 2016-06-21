/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.laozhu.bracket;

import java.util.ArrayList;
import java.util.List;

/**
 * BracketPrinter
 *
 * @author sprzhing
 * @date 16/6/16:11:19
 * @description
 */
public class BracketPrinter {
    private static final int N= 15;

    public static List<String> generateParenThesis(int n){
        List<String> results = new ArrayList<String>();
        generate(n,n,"",results);
        return results;
    }

    public static void generate(int left, int right, String s, List<String> results) {
        if(left == 0 && right == 0){
            results.add(s);
        }
        if(left > 0){
            generate(left -1 ,right, s+"(",results);
        }
        if(right >0 && left < right){
            generate(left, right -1 ,s+")",results);
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenThesis(N);
        for(String s : res){
            System.out.println(s);
        }
    }

}