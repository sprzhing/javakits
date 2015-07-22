package com.baidu.phoenix.file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class PmStatisticUtils {
	private static final String FILE_NAME = "D:/zhuhongquanProject/summer/pmstat/起跑线已开通入口名单.csv";

	public static void main(String[] argv) {
		Map<String, Set<Long>> dataMap = readFile();
		System.out.println(FILE_NAME.substring(FILE_NAME.lastIndexOf("/")));
		for (Map.Entry<String, Set<Long>> entry : dataMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().size());
		}
	}

	@SuppressWarnings("unchecked")
	public static final Map<String, Set<Long>> readFile() {
		List<String> lines = new ArrayList<String>();
		try {
			lines = FileUtils.readLines(new File(FILE_NAME), "UTF-8");
		} catch (Exception e) {
			System.out.println("read file :" + FILE_NAME + "failed "
					+ e.getMessage());
		}
		Map<String, Set<Long>> orgToUsrCout = new HashMap<String, Set<Long>>();
		// 解析文件内容
		for (String line : lines) {
			line.replace("，", ",");
			String[] parts = line.split(",");
			String org = parts[2].trim();
			Long user = Long.parseLong(parts[0].trim());

			if (orgToUsrCout.containsKey(org)) {
				Set<Long> thisOrgUserSet = orgToUsrCout.get(org);
				thisOrgUserSet.add(user);
			} else {
				Set<Long> newOrgUserSet = new HashSet<Long>();
				newOrgUserSet.add(user);
				orgToUsrCout.put(org, newOrgUserSet);
			}
		}
		return orgToUsrCout;
	}
}
