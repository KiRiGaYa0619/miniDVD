package jp.co.brightstar.dvd.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String toMD5(String password) {
        try {
            // 创建 MessageDigest 实例并指定算法为 MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将密码转换为字节数组并进行摘要计算
            byte[] digest = md.digest(password.getBytes());

            // 将摘要结果转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // 处理算法不存在异常
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String password = "123456";
        String md5Password = toMD5(password);
        System.out.println("MD5 Password: " + md5Password);
    }
}
