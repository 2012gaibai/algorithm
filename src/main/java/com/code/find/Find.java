package com.code.find;

/**
 * Created by gq on 2017/2/17.
 */
public class Find {

    public static int halfFind(int[] data,int key){

        int start=0;
        int end=data.length-1;
        int middle;

        while (start<=end){
            middle=(start+end)/2;
            if(key<data[middle]){
                end=middle-1;
            }else if(key>data[middle]){
                start=middle+1;
            }else {
                return middle;
            }
        }

        return -1;

    }
}
