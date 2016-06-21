/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * IpParser
 *
 * @author sprzhing
 * @date 16/4/1:18:40
 * @description
 */
public class IpParser {
    private static final int IP_SIZE = 32;
    private static final int EACH_PART_SIZE = 8;

    /**
     * parse string to ip address
     *
     * @param encryptIp
     *
     * @return
     */
    public String parseToIp(String encryptIp) {
        if (StringUtils.isBlank(encryptIp)) {
            throw new RuntimeException("illegal encryptIp!!");
        }
        String abString = formatEncIp("(\\d*?)(a)", formatEncIp("(\\d*?)(b)", encryptIp));
        return convertIp(abString.replace("a", "0").replace("b", "1"));
    }

    private String convertIp(String ipBinary) {
        if (ipBinary.length() != IP_SIZE) {
            throw new RuntimeException("ip binary failed!");
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ipBinary.length(); i += EACH_PART_SIZE) {
            builder.append(Integer.valueOf(ipBinary.substring(i, i + EACH_PART_SIZE), 2));
            if (i < 3 * EACH_PART_SIZE) {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    private String formatEncIp(String expr, String encryptIp) {
        Pattern pattern = Pattern.compile(expr);
        Matcher matcher = pattern.matcher(encryptIp);
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int end;
        while (matcher.find() && start < encryptIp.length()) {
            end = matcher.start();
            builder.append(encryptIp.substring(start, end));
            String size = matcher.group(1);
            if (StringUtils.isNotBlank(size)) {
                builder.append(translateAlph(matcher.group(1), matcher.group(2)));
            } else {
                builder.append(translateAlph("1", matcher.group(2)));
            }
            start = matcher.end();
        }
        if (start < encryptIp.length()) {
            builder.append(encryptIp.substring(start, encryptIp.length()));
        }
        return builder.toString();
    }

    private String translateAlph(String size, String alph) {
        int count = Integer.parseInt(size);
        StringBuilder res = new StringBuilder();
        while (count > 0) {
            res.append(alph);
            count--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        IpParser parser = new IpParser();
        System.out.println(parser.parseToIp("7ab7ab7a2b6ab"));
        System.out.println(parser.parseToIp("8a8a8a8a"));
        System.out.println(parser.parseToIp("7ba8b8b8b"));
        System.out.println(parser.parseToIp("32b"));
        System.out.println(parser.parseToIp("abababababababababababababababab"));

    }
}
