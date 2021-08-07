package com.yu.ysblog.util;

import java.util.UUID;

/**
 * @Author yu
 * @DateTime 2021/8/7 22:02
 */
public class CommonUtil {

    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
