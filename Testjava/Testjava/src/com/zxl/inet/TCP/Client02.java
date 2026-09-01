package com.zxl.inet.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
@SuppressWarnings({"all"})
public class Client02 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("你好");
        bufferedWriter.newLine();//作为结束标志
        bufferedWriter.flush();//必须刷新！！！！
        System.out.println("客户端已发送数据");

        //接受服务端回传的数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       String str = bufferedReader.readLine();
//        bre.readLine();
//        socket.shutdownInput();
        System.out.println("服务端说" + str);
        try {
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        }catch (Exception e){
            System.out.println("客服端sock已断连");
        }

    }
}
