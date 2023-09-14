package com.itheima.a;
import java.util.Scanner;



public class t20230909oppo2 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); // 小朋友的数量
            String s = sc.next(); // 小朋友的需求
            int[] ans = new int[n + 1]; // 每个座位分配给了哪个小朋友
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '0') { // 如果当前小朋友希望自己是独特的
                    ans[i] = i; // 把他放在他自身的编号对应的座位上
                }
            }
            int j = 1; // 用来记录当前未分配的座位
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '1') { // 如果当前小朋友希望自己是不独特的
                    while (ans[j] != 0) { // 找到一个还没有分配的座位
                        j++;
                    }
                    ans[j] = i; // 把这个座位分配给当前小朋友
                }
            }
            for (int i = 1; i <= n; i++) { // 输出答案
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            sc.close();
        }
}


