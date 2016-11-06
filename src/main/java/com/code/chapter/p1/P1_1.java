package com.code.chapter.p1;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by 甘琪 on 2016/11/1.
 */
public class P1_1 {
    public static final int N = 20;

    public static void main(String[] args) {

        int flag = -1;

        int arrs[] = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            arrs[i] = random.nextInt(100);
        }
        System.out.print("随机数组:");
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
        System.out.println("\n");

        System.out.print("输入:");
        int r;
        Scanner scanner = new Scanner(System.in);

        r = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            if (arrs[i] == r) {
                flag = i;
                break;
            }

        }

        if (flag < 0) {
            System.out.println("unfind");
        } else {
            System.out.println("find:"+r+ "第"+(flag+1)+"个数");
        }

    }
}
