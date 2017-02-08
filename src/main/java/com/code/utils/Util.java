package com.code.utils;

/**
 * 工具类
 * Created by gan on 2015/12/17.
 */
public class Util {
    //打印数组
    public static <T> void printintArr(T[] data) {
        StringBuilder sb = new StringBuilder();
        for (T item : data) {
            sb.append(item).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }

    public static void printIntArr(int[] data){
        for(int i:data){
            System.out.print(i+",");
        }
    }

}
