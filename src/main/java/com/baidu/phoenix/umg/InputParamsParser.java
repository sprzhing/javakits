/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.umg;

/**
 * InputParamsParser
 *
 * @author sprzhing
 * @date 2019/5/23:18:13
 * @description
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParamsParser {
    public Hashtable<String, String> m_hash = new Hashtable();
    public static String STR_PREFIX = "clp";

    public InputParamsParser(String[] vstr) {
        this.create(vstr);
    }

    public InputParamsParser(String strCL) {
        this.create(strCL);
    }

    public boolean create(String[] vstrArg) {
        this.clear();
        this.parseInputParamsWithGaps(vstrArg);
        return true;
    }

    public boolean create(String strCL) {
        return this.create(createCLArray(strCL));
    }

    public static String[] createCLArray(String strCL) {
        Pattern pattern = Pattern.compile("(\"[^\\\"]*\")|([^\"]\\S* ?)");
        Matcher matcher = pattern.matcher(strCL);
        String[] vstr = new String[matcher.groupCount()];

        int i;
        for(i = 0; i < matcher.groupCount(); ++i) {
            matcher.find();
            vstr[i] = matcher.group().toString().trim();
        }

        for(i = 0; i < vstr.length; ++i) {
            vstr[i] = vstr[i].replaceAll("\"", "");
        }

        return vstr;
    }

    public void parseInputParamsWithGaps(String[] vstrArgs) {
        this.clear();
        int nFreeParamCounter = 0;
        boolean bHasKey = false;
        String strKey = null;
        String[] var5 = vstrArgs;
        int var6 = vstrArgs.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String s = var5[var7];
            if (this.isAKey(s)) {
                if (bHasKey) {
                    this.m_hash.put(strKey, "");
                }

                if (this.isNoValueKey(s)) {
                    strKey = s.substring(1, s.length() - 2);
                    this.m_hash.put(strKey, "");
                    bHasKey = false;
                    strKey = null;
                } else {
                    strKey = s.substring(1);
                    bHasKey = true;
                }
            } else if (bHasKey) {
                this.m_hash.put(strKey, s);
                bHasKey = false;
            } else {
                this.m_hash.put(STR_PREFIX + String.valueOf(nFreeParamCounter), s);
                ++nFreeParamCounter;
            }
        }

        if (bHasKey) {
            this.m_hash.put(strKey, "");
        }

    }

    public boolean isAKey(String str) {
        return str.startsWith("-");
    }

    public boolean isNoValueKey(String str) {
        return str.endsWith("-");
    }

    public boolean checkExistence(String strKey) {
        return this.m_hash.containsKey(strKey);
    }

    public String getValue(String strKey) {
        return !this.m_hash.containsKey(strKey) ? null : ((String)this.m_hash.get(strKey)).toString();
    }

    public void clear() {
        if (this.m_hash != null) {
            this.m_hash.clear();
        }

    }

    public static void main(String[] args) {
        String[] ags = new String[]{"-i", "-xml"};
        com.umusic.gsc.teleporter.jTeleporter1.utils.InputParamsParser
                ipp = new com.umusic.gsc.teleporter.jTeleporter1.utils.InputParamsParser(ags);
        if (ipp.checkExistence("i")) {
            boolean bTxt = ipp.checkExistence("txt");
            if (bTxt) {
                System.out.println("Plain text format.");
            } else {
                System.out.println("XML format.");
            }

        } else if (ipp.checkExistence("eo")) {
            String a = ipp.getValue("eo");
            System.out.printf("Extract order #%s.\n", a);
        } else {
            printHelp();
        }
    }

    public static void printHelp() {
        String msg = "Need help?\n-i: Enter \"-i\" to get a list of all orders on the site in XML format.\n-i -txt: Enter \"-i -txt\" to get a list of all orders on the site in plain text format.\n-all: Use \"-all\" to download all orders from the site.\n-eo: Use \"-eo 'order number(s)'\" to download specific orders.For example: -eo 1234 or -eo 1234,5678,9021";
        System.out.println(msg);
    }
}
