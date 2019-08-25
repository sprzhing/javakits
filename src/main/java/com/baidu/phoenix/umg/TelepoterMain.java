/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.umg;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.umusic.gsc.teleporter.ClientProperties;
import com.umusic.gsc.teleporter.ConfigSettingsOverrideHelper;
import com.umusic.gsc.teleporter.ExtractOrdersCommand;
import com.umusic.gsc.teleporter.GetOrderInfoCommand;
import com.umusic.gsc.teleporter.JTeleporter;
import com.umusic.gsc.teleporter.LogConfiguration;
import com.umusic.gsc.teleporter.NetHelper;
import com.umusic.gsc.teleporter.TeleporterConfig;
import com.umusic.gsc.teleporter.jTeleporter1.utils.InputParamsParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

public class TelepoterMain {
    static final String HELP_FILE = "man.txt";
    static String configFilePath;
    static Map<String, String> clientProps = new HashMap();
    static JTeleporter tele;
    private static TeleporterConfig teleConfig;
    private static InputParamsParser ipp;
    private static Logger log = Logger.getLogger(com.umusic.gsc.teleporter.MainClass.class);

    public TelepoterMain() {
    }

    public static void main(String[] args) {
        try {
            args = Arrays.asList("-oid", "all").toArray(new String[0]);
            ipp = new InputParamsParser(args);
            teleConfig = (new ConfigSettingsOverrideHelper(ipp)).getTeleporterConfig();
            (new LogConfiguration(ipp, teleConfig)).configureLogging();
            tele = new JTeleporter(teleConfig);
            if (ipp.checkExistence("i")) {
                if (ipp.checkExistence("rush")) {
                    (new GetOrderInfoCommand(tele, ipp.checkExistence("txt"), "rush")).execute();
                } else if (ipp.checkExistence("norush")) {
                    (new GetOrderInfoCommand(tele, ipp.checkExistence("txt"), "norush")).execute();
                } else {
                    (new GetOrderInfoCommand(tele, ipp.checkExistence("txt"), "all")).execute();
                }

                exit(0);
            }

            if (ipp.checkExistence("oid")) {
                sendClientProperties(args);
                extractOrders();
                exit(0);
            }

            printHelp();
        } catch (Exception var2) {
            if (!var2.getClass().getName().equals(DocumentException.class.getName())) {
                log.error(var2.getMessage());
            }

            exit(1);
        }

    }

    private static void sendClientProperties(String[] args) throws URISyntaxException {
        String cmdKey = "arguments";
        StringBuilder sb = new StringBuilder();
        String[] var3 = args;
        int var4 = args.length;

        String clientPlatformKey;
        for(int var5 = 0; var5 < var4; ++var5) {
            clientPlatformKey = var3[var5];
            sb.append(clientPlatformKey).append(" ");
        }

        clientProps.put(cmdKey, sb.toString());
        String telVerKey = "client_version";
        String clientVersion = String.format("%s %s", ClientProperties.instance.getClient(), ClientProperties.instance.getVersion());
        clientProps.put(telVerKey, clientVersion);
        String javaVerKey = "java_version";
        clientProps.put(javaVerKey, ClientProperties.JavaVersion);
        clientPlatformKey = "client_platform";
        sb = new StringBuilder();
        sb.append(ClientProperties.OsName);
        sb.append(" ");
        sb.append(ClientProperties.OsVersion);
        sb.append("; ");
        sb.append(ClientProperties.OsArch);
        clientProps.put(clientPlatformKey, sb.toString());
        log.info("Client properties:");

        String logInfoPage;
        try {
            sb = new StringBuilder();
            Iterator var7 = clientProps.keySet().iterator();

            while(var7.hasNext()) {
                logInfoPage = (String)var7.next();
                sb.append(logInfoPage);
                sb.append("=");
                String value = (String)clientProps.get(logInfoPage);
                sb.append(URLEncoder.encode(value, "UTF-8"));
                sb.append("&");
                log.info(String.format("%s: %s", logInfoPage, value));
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        String clientProps = sb.toString();
        logInfoPage = teleConfig.getContentSiteBaseUrl() + "/" + "20181123" + "/LogClientInfo.aspx";

        try {
            NetHelper.writeStringToUrl(logInfoPage, teleConfig.getContentSiteBaseUrl(), teleConfig.getUserName(), teleConfig.getPassword(), clientProps);
        } catch (IOException var10) {
            System.out.printf("Error sending client properties: %s\n", var10.getMessage());
            var10.printStackTrace();
        }

    }

    private static void extractOrders() throws Exception {
        (new ExtractOrdersCommand(tele, ipp)).execute();
    }

    public static void printHelp() {
        StringBuilder sb = new StringBuilder();
        InputStream iS = null;
        InputStreamReader iSR = null;
        BufferedReader reader = null;

        try {
            iS = ClassLoader.getSystemResourceAsStream("man.txt");
            iSR = new InputStreamReader(iS);
            reader = new BufferedReader(iSR);

            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.getProperty("line.separator"));
            }
        } catch (Exception var13) {
            log.error("An error occurred when reading the Help File!");
        } finally {
            try {
                reader.close();
                iSR.close();
                iS.close();
            } catch (IOException var12) {
                log.error("Couldn't finish Help File reading correctly!");
            }

        }

        System.out.println(sb.toString());
    }

    private static void exit(int exitCode) {
        shutDownLogger();
        System.exit(exitCode);
    }

    private static void shutDownLogger() {
        try {
            log.info("Shutting down.");
            Thread.sleep(100L);
            LogManager.shutdown();
        } catch (Throwable var1) {
            ;
        }

    }
}
