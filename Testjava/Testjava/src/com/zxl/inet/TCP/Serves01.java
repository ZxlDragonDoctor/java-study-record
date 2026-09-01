package com.zxl.inet.TCP;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class Serves01 {
    //服务端
    public static void main(String[] args) throws IOException {
        //监听8888端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("端口待连接");
        //连接，生成socket
        Socket socket = serverSocket.accept();
        //读入数据并写入磁盘(边读边写)
        String destpath = "src\\com\\lin2.jpg";//IO操作的是文件，而不是文件夹！！！！
        BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
        byte[] array = new byte[1024];
        int len = 0;
        FileOutputStream fou = new FileOutputStream(destpath);
        while ((len = bin.read(array))!=-1){
            fou.write(array,0,len);
        }
        fou.flush();
        socket.shutdownInput();
        fou.close();
        bin.close();
        socket.close();


    }
}
