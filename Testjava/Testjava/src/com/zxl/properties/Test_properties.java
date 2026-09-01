package com.zxl.properties;

import java.io.*;
import java.util.Properties;

public class Test_properties {
    public static void main(String[] args) throws IOException {
        //Properties实验
        String src = "src\\com\\zxl\\properties\\mysql.properties";
        BufferedReader buf = new BufferedReader(new FileReader(src));
        String str = "";
        while ((str=buf.readLine())!=null){
            String[] arr = str.split("=");
            System.out.println(arr[0] + arr[1]);
        }
        buf.close();

        // 配置文件
        String classpath = "";
        Properties pro = new Properties();
        pro.load(new FileReader(src));
        String ip = pro.getProperty("ip");
        pro.setProperty("number","17783366413");
        pro.setProperty("locate","北京");
        pro.store(new FileWriter(src),null);
        pro.list(System.out);

        //反射实验

    }

}
