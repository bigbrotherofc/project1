package com.itheima.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class t20230907xiecheng2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = sc.next().toCharArray();
        }
        List<Integer[]> y= new ArrayList<>();
        List<Integer[]> u= new ArrayList<>();
        List<Integer[]> o= new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'y') {
                    Integer [] a = new Integer[]{i,j};
                    y.add(a);
                }
                if (mat[i][j] == 'o') {
                    Integer [] a = new Integer[]{i,j};
                    o.add(a);
                }
                if (mat[i][j] == 'u') {
                    Integer [] a = new Integer[]{i,j};
                    u.add(a);
                }
            }
        }
        for(Integer[] a:y){
            for(Integer[] b:o){
                for(Integer[] c:u){
                    int x1 = a[0];
                    int y1 = a[1];
                    int x2 = b[0];
                    int y2 = b[1];
                    int x3 = c[0];
                    int y3 = c[1];
                    int len1= ((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2));
                    int len2= ((x1 - x3) * (x1 - x3)) + ((y1 - y3) * (y1 - y3));
                    int len3= ((x2 - x3) * (x2 - x3)) + ((y2 - y3) * (y2 - y3));
                    if(len1+len2==len3){
                        if((x1==x2&&y1==y3)||(x1==x3&&y1==y2)) {
                            ans++;
                        }
                    }
                    if(len1+len3==len2){
                        if((x1==x3&&y1==y2)||(x1==x2&&y1==y3))
                            ans++;
                    }
                    if(len2+len3==len1){
                        if((x2==x3&&y1==y2)||(x1==x2&&y2==y3))
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

