package com.code.sort;

import com.code.utils.Util;

/**
 * Created by gq on 2017/2/8.
 */
public class SortMethod {

    public static void main(String[] args) {
        int[] a = {3, 7, 4, 2, 2, 3, 1};
//        bubbleSort(a);
//        quickSort(a, 0, a.length - 1);
//        insertSort(a);
        halfInsert(a);
        Util.printIntArr(a);
    }

    /**
     * 冒泡排序：
     */
    public static void bubbleSort(int[] arrs) {
        int len = arrs.length;
        int temp;

        for (int i = 0; i < len - 1; i++) {
            //设置交换标记
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;

                    flag = true;
                }

            }
            //如果一趟遍历下来，没有发生交换，说明排序已完成
            if (!flag) {
                break;
            }

        }

    }

    /**
     * 快速排序：
     */

    public static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int middle = getMiddle(data, left, right);
            quickSort(data, left, middle - 1);
            quickSort(data, middle + 1, right);
        }

    }

    private static int getMiddle(int[] data, int left, int right) {
        int key = data[left];
        while (left < right) {
            while (left < right && data[right] >= key) {
                right--;
            }
            data[left] = data[right];
            while (left < right && data[left] < key) {
                left++;
            }
            data[right] = data[left];
        }
        data[left] = key;
        return left;

    }

    /***
     * 直接插入排序
     */

    public static void insertSort(int[] data) {
        int len = data.length;
        int temp;
        int j;
        for (int i = 1; i < len; i++) {
            temp = data[i];
            for (j = i; j > 0 && temp < data[j - 1]; j--) {
                data[j] = data[j - 1];
            }
            data[j] = temp;
        }
    }

    /**
     * 二分法插入排序
     */

    public static void halfInsert(int[] data) {
        int len = data.length;

        int temp;

        for (int i = 1; i < len; i++) {
            int left = 0;
            int right = i - 1;
            temp = data[i];
            int midd;
            while (left <= right) {
                midd = (left + right) / 2;
                if(temp<data[midd]){
                    right=midd-1;
                }else {
                    left=midd+1;
                }

            }
            for (int j = i - 1; j >= left; j--) {
                data[j + 1] = data[j];
            }

            if (i != left) {
                data[left] = temp;
            }

        }
    }
}
