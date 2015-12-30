package com.code.utils;

/**
 * 工具类
 * Created by gan on 2015/12/17.
 */
public class Util {
    //打印int数组
    public static void printintArr(int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int item : data) {
            sb.append(item).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }
}
