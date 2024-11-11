package com.esms.utils;

import org.junit.Test;

public class MD5UtilsTest {
    @Test
    public void testMD5Encode(){
        // 数据源及是，密码
        String originString = "123" ;
        // 静态调用，MD5Utils.encodeByMD5(),返回的字符串为md5 32位字符，及加密后的密码
        String encodeByMD5 = MD5Utils.encodeByMD5(originString);
        System.out.println(encodeByMD5);
    }
}
