package com.baidu.phoenix.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class SqlBuilderUtils {
    public static final String CSV_FILE = "/Users/zhuhongquan/laozhu/temp/3.csv";
    public static final String BONUS_FILE = "/Users/zhuhongquan/Documents/优惠.csv";
    public static final String LAUNCH_UPDATE =
            "update launch_cost L set L.lost_bonus = {launchBonus} where L.id = {launchId};";
    public static final String VAS_LAUNCH_UPDATE =
            "update vas_launch_cost L set L.lost_bonus = {vasLaunchBonus} where L.id = {vasLaunchId};";
    public static final String UPGRADE_LAUNCH_UPDATE =
            "update upgrade_lemma_info U set U.diff_lost_bonus={diffBonus} where U.lemma_id = {upgradeLaunchId};";
    public static final String INSERT_FORMAT =
            "insert into upgrade_lemma_info(lemma_id,ader_id,original_price,original_paytime,original_onlinedate,diff_price,refund_price,create_time,update_time)"
                    + "values({lemmaId},{aderId},{oldPrice},'{oldPayTime}','{oldOnlineDate}',{diffPrice},{refundPrice},'{upgradeDate}','{refundDate}');";

    public static final String LEVEL1 = "INSERT INTO table_cpc_industry(name,code,level,is_available) VALUES"
            + "({name},"
            + "{code},1,1);";
    public static final String LEVEL23 = "INSERT INTO table_cpc_industry(name,code,parent,level,is_available) "
            + "VALUES"
            + "({name},{code},{parent},3,1);";

    public static class InsertBean {
        public String lemmaId;
        public String aderId;
        public String oldPrice;
        public String oldPayTime;
        public String oldOnlineDate;
        public String diffPrice;
        public String refundPrice;
        public String upgradeDate;
        public String refundDate;
    }

    public static class UpdateBonusBean {
        public String id; // [0]
        public String bonus; // [2]
    }

    public static class Industry{
        public String name;
        public Long code;
        public Long parent;
    }
    public static void main(String[] argv){
        List<String> updateCmdList = parseFile();
        for (String cmd : updateCmdList) {
            System.out.println(cmd);
        }
    }

    public static List<String> parseFile() {
        List<String> insertCmds = new ArrayList<String>();
        List<String> lines = new ArrayList<String>();
        try {
            lines = FileUtils.readLines(new File(CSV_FILE), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            String[] tokens = line.split(",", -1);
            Long parent = Long.parseLong(tokens[0].trim())/100;
            String insert = LEVEL23.replace("{name}","\'"+tokens[1].trim()+"\'")
                    .replace("{code}",tokens[0].trim()).replace("{parent}",parent.toString());
            insertCmds.add(insert);

            /*if (tokens[0].startsWith("vas")) {
                String updateCmd =
                        VAS_LAUNCH_UPDATE.replace("{vasLaunchId}", tokens[0].replace("vas", "").trim()).replace(
                                "{vasLaunchBonus}", tokens[2].trim());
                updateCmds.add(updateCmd);

            } else if (tokens[0].startsWith("up")) {
                String updateCmd =
                        UPGRADE_LAUNCH_UPDATE.replace("{upgradeLaunchId}", tokens[0].replace("up", "").trim()).replace(
                                "{diffBonus}", tokens[2].trim());
                updateCmds.add(updateCmd);
            } else {
                String updateCmd =
                        LAUNCH_UPDATE.replace("{launchId}", tokens[0].trim())
                                .replace("{launchBonus}", tokens[2].trim());
                updateCmds.add(updateCmd);
            }*/
        }
        return insertCmds;
    }
}
