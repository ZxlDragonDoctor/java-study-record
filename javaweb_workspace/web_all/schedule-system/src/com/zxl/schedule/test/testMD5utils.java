package com.zxl.schedule.test;

import com.zxl.schedule.util.MD5Util;
import org.junit.jupiter.api.Test;

public class testMD5utils {
    @Test
    public void testMD5(){
        String pwd = "12345";
        String s = MD5Util.encrypt(pwd);
        System.out.println(s);
    }
}
