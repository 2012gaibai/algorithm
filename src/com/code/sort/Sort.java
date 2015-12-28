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
//        quickSort(s, 0, s.length - 1);
        bubbleSort(s);
        Util.printintArr(s);
    }

    //冒泡排序
    public static void bubbleSort(int data[]) {
        int len = data.length;
        int temp;
        for (int i = len - 1; i > 0; i--) {
            boolean flag = false;//记录是否发生交换
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }
            // 冒泡排序算法结束条件：在一趟排序过程中没有进行过交换操作
            if (!flag)
                break;
        }

    }

    //快速排序：分治法+挖坑填数
    public static void quickSort(int s[], int left, int right) {
        if (left < right) {//递归结束的条件，left==right
            int i = left, j = right;//定义左右两个指针
            int key = s[i];//挖第一个坑
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
