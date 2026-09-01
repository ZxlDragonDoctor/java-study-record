package com.zxl.inet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@SuppressWarnings({"all"})
public class Udp_B {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        //接收信息
        byte[] bytes = new byte[1024];
        DatagramPacket Packet = new DatagramPacket(bytes,bytes.length);
        socket.receive(Packet);
        //拆包
        bytes = Packet.getData();
        int length = Packet.getLength();
        String str = new String(bytes,0,length);
        System.out.println(str);
        //发送信息
        byte[] bytes1 = new byte[1024];
        bytes1 = "你好,我是吴凯".getBytes();
        Packet = new DatagramPacket(bytes1,bytes1.length, InetAddress.getByName("Dragon"),9999);
        socket.send(Packet);



        //关闭资源
        socket.close();
    }
}
