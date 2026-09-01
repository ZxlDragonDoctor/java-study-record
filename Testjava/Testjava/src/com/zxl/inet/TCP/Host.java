package com.zxl.inet.TCP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Host {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//Dragon/172.26.87.94
        InetAddress host = InetAddress.getByName("Dragon");
        System.out.println(host);
        String hostname = host.getHostName();
        System.out.println(hostname);
        String hostIp = host.getHostAddress();
        System.out.println(hostIp);
    }
}
