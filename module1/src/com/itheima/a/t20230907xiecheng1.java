package com.itheima.a;

import java.util.*;

public class t20230907xiecheng1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a > r) pq.offer(a);
            }
            int ans = 0;
            while (!pq.isEmpty()) {
                int x = pq.poll();
                x--;
                ans++;
                if (x > r) pq.offer(x);
            }
            System.out.println(ans);
        }
        sc.close();
    }

}
