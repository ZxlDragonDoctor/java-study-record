package com.zxl.inet.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class Serves02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器待连结");
        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接服务器");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = bufferedReader.readLine();
        System.out.println("客户端说"+str);

        //服务端回传数据(要求用字符流)
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("你也好");
        bufferedWriter.newLine();//作为结束标志
        bufferedWriter.flush();//刷新！！！
//        buw.newLine();//同样可作为结束标志

        try {
            bufferedWriter.close();
            bufferedReader.close();
            socket.close();
            serverSocket.close();
        }catch (Exception e){
            System.out.println("服务器sock已断连");
        }

    }
}
