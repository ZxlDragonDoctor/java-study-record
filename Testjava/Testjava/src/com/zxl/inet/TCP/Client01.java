package com.zxl.inet.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings({"all"})
public class Client01 {
    //客户端
    public static void main(String[] args) throws IOException {
        //ip,端口号
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        //从磁盘读入文件(边读边写)写入到流
        BufferedOutputStream bou = new BufferedOutputStream(socket.getOutputStream());
        String srcpath = "D:\\lin.jpg";
        byte[] arrray = new byte[1024];
        int len = 0;
        FileInputStream fin = new FileInputStream(srcpath);
        while((len = fin.read(arrray))!=-1){
            bou.write(arrray,0,len);
        }
        bou.flush();
        socket.shutdownOutput();
        fin.close();
        bou.close();
        socket.close();




    }
}
