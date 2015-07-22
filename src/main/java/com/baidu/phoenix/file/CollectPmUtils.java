package com.baidu.phoenix.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.baidu.nmp.base.utils.DateUtils;

public class CollectPmUtils {
    public static void main(String arg[]) throws IOException {
        List<String> inputLines = FileUtils.readLines(new File("/Users/zhuhongquan/Desktop/baiketj.txt"));

        Set<String> aderSet = new HashSet<String>();

        for (String line : inputLines) {
            aderSet.add(line.split("\\t")[0].trim());
        }

        List<String> output = new ArrayList<String>();

        for (String aderId : aderSet) {
            String costOfAder = aderId;
            for (Date d = DateUtils.str2Date("20140501", "yyyyMMdd"); d.before(new Date()); d = DateUtils.addMonths(d, 1)) {
                String prefix = aderId + "\t" + DateUtils.date2Str(d, "yyyyMM");
                String cost = null;
                for (String line : inputLines) {
                    if (line.startsWith(prefix)) {
                        // cost = StringUtils.substringAfter(line, prefix).trim();
                        break;
                    }
                }
                if (cost == null) {
                    cost = "0";
                }
                costOfAder += "\t" + cost;
            }
            output.add(costOfAder);
        }

        FileUtils.writeLines(new File("/Users/liyuanhang/workspace/Test/cost.out.txt"), output);
    }
}
