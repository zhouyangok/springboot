package com.crazyang.common.utils;

import java.text.SimpleDateFormat;

/**
 * @ClassName GetTimeID
 * @Description: 获取id工具类
 * @Author zhouyang
 * @Date 2019/3/25 下午4:56.
 */

public class GetTimeID {
    /**
     * 20位末尾的数字id
     */
    public static volatile int Guid=100;

    public static String getGuid() {

        GetTimeID.Guid+=1;

        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        //获取时间戳
        String time=dateFormat.format(now);
        String info=now+"";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        int ran=0;
        if(GetTimeID.Guid>999){
            GetTimeID.Guid=100;
        }
        ran=GetTimeID.Guid;

        return time+info.substring(2, info.length())+ran;
    }

    public static Integer getTimeId() {

        GetTimeID.Guid+=1;

        long now = System.currentTimeMillis();
        //获取时间戳
        String info=now+"";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        int ran=0;
        if(GetTimeID.Guid>999){
            GetTimeID.Guid=100;
        }
        ran=GetTimeID.Guid;
        return Integer.parseInt(info.substring(7, info.length())+ran);
    }
}
