package com.zxl.inet.UDP;

import java.io.IOException;
import java.net.*;

@SuppressWarnings({"all"})
public class Udp_A {
    //udp原理实践
    public static void main(String[] args) throws IOException {
        //在9999号端口监听
        DatagramSocket socket =  new DatagramSocket(9999);
        //一个数据包大小是64k
        //发送信息
        byte[] bytes = new byte[1024];
        bytes = "你好,我是王争".getBytes();
        DatagramPacket Packet = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("Dragon"),9998);
        socket.send(Packet);
        //接收信息
        byte[] bytes1 = new byte[1024];
        Packet = new DatagramPacket(bytes1,bytes1.length);
        socket.receive(Packet);
        //拆包
        bytes1 = Packet.getData();//注意！ 接受和发送信息最好不要用同一个数组，否则B端只能发送与A端相同长度的信息
        int length = Packet.getLength();
        String str = new String(bytes1,0,length);
        System.out.println(str);

        //关闭资源
        socket.close();




    }
}
