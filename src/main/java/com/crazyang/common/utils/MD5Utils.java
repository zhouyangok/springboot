package com.crazyang.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by zhouyang
 * Date 2019/3/5.
 */
public class MD5Utils {
    public static final String KEY_MD5 = "MD5";

    public static String getResult(String inputStr) {
        BigInteger bigInteger = null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigInteger.toString(16);
    }
}
