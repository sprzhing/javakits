package com.baidu.phoenix.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
import com.baidu.maindata.service.AccountService;
import com.baidu.rigel.platform.datatable.DataTable;

public class RmiRemote {
	public static void main(String args[]) {
		try {
			// Hello remoteHello = (Hello)
			// Naming.lookup("rmi://127.0.0.1/server");
			// System.out.println(remoteHello.sayHi());
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.summer.xml");
			// AccountService accountService = (AccountService)
			// Naming.lookup("rmi://10.48.29.30:8608");
			AccountService service = (AccountService) ctx
					.getBean("accountMdmProxy");
			List<Long> aderIds = getIdList();
			System.out.println(aderIds.size());
			System.out.println("开始。。。。");
			List<String> lines = new ArrayList<String>();
			int i = 1;
			for (Long ader : aderIds) {
				DataTable table = service.getAcctInfo(ader);
				String line = table
						.getCell(0, table.getColumnIndex("main_lice_name"))
						.getValue().toString()
						+ "\t" + ader;
				lines.add(line);
				System.out.println("process..." + i + "/" + aderIds.size());
				i++;
				Thread.sleep(10);
			}
			writeInfo(lines);
			System.out.println("记录完毕！");
			// DataTable table = service.getAcctInfo(6396151L);
			// System.out.println("column no:" + table.getNumberOfColumns());
			// System.out.println(table.containsColumn("main_lice_name"));
			// System.out.println("main_lice_name index:"
			// + table.getColumnIndex("main_lice_name"));
			// System.out.println("81 index:" + table.getColumnIndex("81"));
			// System.out.println("row no:" + table.getNumberOfRows());
			// System.out.println("0 row,81 column:"
			// + table.getCell(0, 81).getValue());
			// System.out.println(table.getCell(0, 81).getFormattedValue());
			// System.out.println(table.getCell(0, 81).getCustomProperties());
			// System.out.println(table.getCell(0, 81).getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Long> getIdList() throws IOException {
		List<Long> ids = new ArrayList<Long>();
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"D://1.txt")));
		String line = null;
		while ((line = reader.readLine()) != null) {
			ids.add(Long.parseLong(line.trim()));
		}
		if (reader != null) {
			reader.close();
		}
		return ids;
	}

	public static void writeInfo(List<String> lines) throws IOException {
		PrintWriter printWriter = new PrintWriter(new File(
				"D://lemma_ader_mdm.txt"));
		for (String line : lines) {
			printWriter.println(line);
		}
		if (printWriter != null) {
			printWriter.close();
		}

	}
}
*/
