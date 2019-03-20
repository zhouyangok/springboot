package com.crazyang.common.utils;

import java.util.UUID;

/**
 * @ClassName UUIDUtils
 * @Description: 随机生成id
 * @Author zhouyang
 * @Date 2019/3/20 下午4:58.
 */

public class UUIDUtils {

    public static Integer getUUID(){
        String uid = String.valueOf(UUID.randomUUID()).replaceAll("-", "");
        return Integer.valueOf(uid);

    }
}
