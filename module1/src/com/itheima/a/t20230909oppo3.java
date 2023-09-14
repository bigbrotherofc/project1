package com.itheima.a;

import java.util.Scanner;

import java.util.Scanner;

public class t20230909oppo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数组长度
        int ans = 0; // 最终答案
        int dp = 0; // 当前dp值
        for (int i = 0; i < n - 1; i++) {
            int b = sc.nextInt(); // b数组元素
            if (b > 0) { // 如果是正数，开始新的区间
                dp = 1;
            } else { // 如果是负数或零，延续上一个区间
                dp++;
            }
            ans = Math.max(ans, dp); // 更新答案
        }
        System.out.println(ans); // 输出答案
        sc.close();
    }
}
