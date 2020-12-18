package com.bjpowernode.crm.base.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.base.util
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/17 17:40
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class MD5Util {
    public static String getMd5(String password) {

        try {
            //获取一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            //把每一个byte做一个与运算 0xff；
            for (byte b : result) {
                //与运算
                int number = b & 0xff;//加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);

            }
            //标准的MD5加密后的结果
            return buffer.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }


    }


}
