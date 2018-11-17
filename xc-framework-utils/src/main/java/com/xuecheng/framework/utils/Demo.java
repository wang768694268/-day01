package com.xuecheng.framework.utils;

public class Demo {
    public static void main(String[] args) {
        String md5 = MD5Util.getStringMD5("wjc19890320wjc");
        System.out.println(md5);
        String Str = "wjc19890320wjc";
        String Str1 = MD5Util.getStringMD5(Str);
        System.out.println(Str1);
        boolean eq = md5.equals(Str1);
        System.out.println(eq);
    }
}
