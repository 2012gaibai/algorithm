package com.code.sort;

import com.code.utils.Util;

/**
 * 排序算法
 * Created by gan on 2015/12/17.
 */
public class Sort {

    public static void main(String[] args) {
        int s[] = {6, 5, 3, 1, 8, 7, 2, 4};
        Util.printintArr(s);
        quickSort(s, 0, s.length - 1);
        Util.printintArr(s);
    }

    //冒泡排序
    public static void BubbleSort(int data[]) {

    }

    //快速排序：分治法+挖坑填数
    public static void quickSort(int s[], int left, int right) {
        if (left < right) {//递归结束的条件，left==right
            int i = left, j = right;//定义左右两个指针
            int key = s[left];//挖第一个坑
            while (i < j) {
                while (s[j] >= key && i < j) {//从右往左找第一个小于等于key的数
                    j--;
                }
                s[i] = s[j];//挖第二个数填第一个坑
                while (i < j && s[i] < key) {
                    i++;
                }
                s[j] = s[i];//挖第三个数填第二个坑
            }
            s[i] = key;//把key填到最后一个坑上。。一个循环
            quickSort(s, left, i - 1);
            quickSort(s, i + 1, right);
        }
    }
}
