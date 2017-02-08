package com.code.sort;

import com.code.utils.Util;

/**
 * Created by gq on 2017/2/8.
 */
public class SortMethod {

    public static void main(String[] args) {
        int[] a={3,7,4,2,1};
        bubbleSort(a);
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
}
